package org.toilelibre.libe.prime;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

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
        }), LIKE ("~~", new Tester () {

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
                    final String fieldAsString = condition.getExpression ().replaceAll (Tester.ATTRIBUTE, "$1");
                    final Field field = candidateDbo.getClass ().getDeclaredField (fieldAsString);
                    field.setAccessible (true);
                    return field.get (candidateDbo);
                }
                return candidateDbo.getClass ().getMethod (condition.getExpression ()).invoke (candidateDbo);
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                return null;
            }
        }

        abstract boolean test (PrimeWhere condition, Object candidateDbo);
    }

    static boolean matchesCondition (final Object candidateDbo, final PrimeWhere cond) {
        return Operator.fromSymbol (cond.getOperator ()).test (cond, candidateDbo);
    }
}
