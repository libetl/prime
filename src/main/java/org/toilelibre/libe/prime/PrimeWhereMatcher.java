package org.toilelibre.libe.prime;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class PrimeWhereMatcher {

    enum Operator {
        EQUALS ("==", new Tester () {
            @Override
            public boolean test (final PrimeWhere condition, final Object candidateDbo) {
                return ("" + this.getCandidateValue (condition, candidateDbo)).equals (condition.getValue ());
            }
        }), DIFFERENT ("!=", new Tester () {

            @Override
            public boolean test (final PrimeWhere condition, final Object candidateDbo) {
                return ! ("" + this.getCandidateValue (condition, candidateDbo)).equals (condition.getValue ());
            }
        }), LIKE ("~=", new Tester () {

            @Override
            public boolean test (final PrimeWhere condition, final Object candidateDbo) {
                return ("" + this.getCandidateValue (condition, candidateDbo)).matches (".*" + condition.getValue () + ".*");
            }
        });

        static Operator fromSymbol (final String symbol1) {
            for (final Operator operator : Operator.values ()) {
                if (operator.symbol.equals (symbol1)) {
                    return operator;
                }
            }
            return null;
        }

        private final String symbol;

        private final Tester tester;

        Operator (final String symbol1, final Tester tester1) {
            this.symbol = symbol1;
            this.tester = tester1;
        }

        public boolean test (final PrimeWhere condition, final Object candidateDbo) {
            return this.tester.test (condition, candidateDbo);
        }
    }

    static abstract class Tester {
        private static final String ATTRIBUTE = "attribute\\[([^\\]]+)\\]";

        public Object getCandidateValue (final PrimeWhere condition, final Object candidateDbo) {

            try {
                if (condition.getExpression ().matches (Tester.ATTRIBUTE)) {
                    return this.returnFieldValue (condition, candidateDbo);
                }
                return this.returnMethodResult (condition, candidateDbo);
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                return null;
            }
        }

        private Method getMethodByName (final PrimeWhere condition, final Object candidateDbo) {
            final String methodName = condition.getExpression ().indexOf ('(') != -1 ? condition.getExpression ().substring (0, condition.getExpression ().indexOf ('('))
                    : condition.getExpression ();
            for (final Method method : candidateDbo.getClass ().getMethods ()) {
                if (method.getName ().equals (methodName)) {
                    return method;
                }
            }
            return null;
        }

        private Object returnFieldValue (final PrimeWhere condition, final Object candidateDbo) throws NoSuchFieldException, IllegalAccessException {
            final String fieldAsString = condition.getExpression ().replaceAll (Tester.ATTRIBUTE, "$1");
            final Field field = candidateDbo.getClass ().getDeclaredField (fieldAsString);
            field.setAccessible (true);
            return field.get (candidateDbo);
        }

        private Object returnMethodResult (final PrimeWhere condition, final Object candidateDbo) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            final Method m = this.getMethodByName (condition, candidateDbo);
            if (m == null) {
                return null;
            }
            m.setAccessible (true);
            if (condition.getArgs () != null) {
                return m.invoke (candidateDbo, condition.getArgs ());
            }
            return m.invoke (candidateDbo);
        }

        abstract boolean test (PrimeWhere condition, Object candidateDbo);
    }

    static boolean matchesCondition (final Object candidateDbo, final PrimeWhere cond) {
        if ("?".equals (cond.getExpression ())) {
            return Boolean.valueOf (cond.getValue ());
        }
        return Operator.fromSymbol (cond.getOperator ()).test (cond, candidateDbo);
    }
}
