package org.toilelibre.libe.prime;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import groovy.util.Eval;

class PrimeWhereMatcher {

    enum Operator {
        EQUALS ("==", new Tester () {
            @Override
            public boolean test (final PrimeWhere condition, final Object candidateDbo) {
                return (boolean) Eval.x (this.getCandidateValue (condition, candidateDbo), "x.equals (" + condition.getValue () + ")");
            }
        }), DIFFERENT ("!=", new Tester () {

            @Override
            public boolean test (final PrimeWhere condition, final Object candidateDbo) {
                return (boolean) Eval.x (this.getCandidateValue (condition, candidateDbo), "!x.equals (" + condition.getValue () + ")");
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
            throw new PrimeException ("Unknown operator : '" + symbol1 + "'. If you think it is a real operator, please e-mail the devs of the prime lib.");
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
                throw new PrimeException ("While checking the parameter value for a candidate, an exception was found", e);
            }
        }

        private Method getMethod (final PrimeWhere condition, final Object candidateDbo) {
            final String methodName = condition.getExpression ().indexOf ('(') != -1 ? condition.getExpression ().substring (0, condition.getExpression ().indexOf ('('))
                    : condition.getExpression ();
            if (condition.getParamTypes () != null) {
                try {
                    return candidateDbo.getClass ().getDeclaredMethod (methodName, condition.getParamTypes ());
                } catch (NoSuchMethodException | SecurityException e) {
                    throw new PrimeException ("Problem with the method '" + methodName + "'. Please check the syntax in your call.");
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
            final Method m = this.getMethod (condition, candidateDbo);

            if ( (m != null) && (condition.getArgs () != null)) {
                m.setAccessible (true);
                return m.invoke (candidateDbo, condition.getArgs ());
            }
            // the more we avoid to go inside the groovy layer, the faster it is
            return Eval.x (candidateDbo, "x." + condition.getExpression ());
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
