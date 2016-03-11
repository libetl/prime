package org.toilelibre.libe.prime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Converts a list of conditions into a tree of nested subconditions map This
 * structure can be more easily resolved than a flat list Example : [ dbwc1 and
 * dbwc2 or (dbwc3 and (dbwc4 or dbwc5)) and dbwc6 ] => dbwc1 and dbwc2 or
 * \____________________________________ and dbwc6 | \_ dbwc3 and \ | \_ dbwc4
 * or dbwc5
 *
 *
 */
class PrimeWhereSubExprFinder {

    static class SubExpression implements Cloneable {
        private final int              start;
        private final int              end;
        private final List<PrimeWhere> expressions;

        public SubExpression (final int start, final int end, final List<PrimeWhere> expressions) {
            super ();
            this.start = start;
            this.end = end;
            this.expressions = expressions;
        }

        public int getEnd () {
            return this.end;
        }

        public List<PrimeWhere> getExpressions () {
            return this.expressions;
        }

        public int getStart () {
            return this.start;
        }
    }

    private static void addToResult (final List<PrimeWhere> conditions, final int level, final List<List<SubExpression>> result, final int innerStart, final int innerEnd) {
        while (result.size () <= level) {
            result.add (new LinkedList<SubExpression> ());
        }
        final List<PrimeWhere> subList = conditions.subList (innerStart, Math.min (innerEnd + 1, conditions.size ()));
        result.get (level).add (new SubExpression (innerStart, innerEnd, subList));
    }

    private static void concatenateResultWith (final List<List<SubExpression>> result, final List<List<SubExpression>> additions) {
        result.addAll (additions);
    }

    /**
     * Reads the conditions and transform them into a tree of nested conditions
     * It uses the openConds and closeConds fields to know if a parenthesis is
     * opened or closed.
     *
     * @param conditions
     *            a flat list of conditions
     * @return a map of nested conditions
     */
    public static List<List<SubExpression>> findSubConditions (final List<PrimeWhere> conditions) {
        if ( (conditions == null) || !PrimeWhereSubExprFinder.pairingIsOk (conditions)) {
            throw new PrimeException ("Invalid conditions passed in parameters, please check the pairing of the nested criterias.");
        }
        final ArrayList<PrimeWhere> conditions2 = new ArrayList<PrimeWhere> (conditions.size ());
        for (final PrimeWhere condition : conditions) {
            try {
                conditions2.add ((PrimeWhere) condition.clone ());
            } catch (final CloneNotSupportedException e) {
            }
        }
        final List<List<SubExpression>> result = new LinkedList<> ();
        PrimeWhereSubExprFinder.concatenateResultWith (result, PrimeWhereSubExprFinder.findSubconds (conditions2, 0, conditions.size () - 1, 0));
        PrimeWhereSubExprFinder.addToResult (conditions2, 0, result, 0, Math.max (0, conditions.size () - 1));
        return result;
    }

    private static List<List<SubExpression>> findSubconds (final List<PrimeWhere> conditions, final int start, final int end, final int level) {
        if (start >= end) {
            return Collections.emptyList ();
        }
        final List<List<SubExpression>> result = new LinkedList<> ();
        int nestedLevel = 0;
        int innerStart = 0;
        int innerEnd = 0;
        for (int i = start ; i <= end ; i++) {
            final PrimeWhere thisCondition = conditions.get (i);
            switch (thisCondition.getOpenedParentheses ()) {
            case 0 :
                break;
            default :
                if (nestedLevel == 0) {
                    innerStart = i;
                }
                nestedLevel += thisCondition.getOpenedParentheses ();
                break;
            }
            switch (thisCondition.getClosedParentheses ()) {
            case 0 :
                break;
            default :
                nestedLevel -= thisCondition.getClosedParentheses ();
                if (nestedLevel <= 0) {
                    innerEnd = i;
                    PrimeWhereSubExprFinder.restartSameScopeNestedOnce (conditions, level, result, innerStart, innerEnd);
                }
                break;
            }
        }
        return result;
    }

    private static boolean pairingIsOk (final List<PrimeWhere> conditions) {
        if (conditions.isEmpty ()) {
            return true;
        }
        int level = 0;
        for (int i = 0 ; i < conditions.size () ; i++) {
            level += conditions.get (i).getOpenedParentheses ();
            level -= conditions.get (i).getClosedParentheses ();
            if (level < 0) {
                return false;
            }
        }
        return true;
    }

    private static void restartSameScopeNestedOnce (final List<PrimeWhere> conditions, final int level, final List<List<SubExpression>> result, final int innerStart,
            final int innerEnd) {
        final List<PrimeWhere> subConditions = new ArrayList<> (conditions);
        final PrimeWhere startCondition = conditions.get (innerStart);
        final PrimeWhere endCondition = conditions.get (innerEnd);
        PrimeWhereSubExprFinder.addToResult (conditions, level + 1, result, innerStart, innerEnd);
        subConditions.set (innerStart,
                new PrimeWhere (startCondition.getConjunction (), (startCondition.getOpenedParentheses () <= 0 ? 0 : startCondition.getOpenedParentheses () - 1),
                        startCondition.getExpression (), startCondition.getParamTypes (), startCondition.getArgs (), startCondition.getOperator (), startCondition.getValue (),
                        startCondition.getClosedParentheses ()));
        subConditions.set (innerEnd,
                new PrimeWhere (endCondition.getConjunction (), endCondition.getOpenedParentheses (), endCondition.getExpression (), startCondition.getParamTypes (),
                        endCondition.getArgs (), endCondition.getOperator (), endCondition.getValue (),
                        (endCondition.getClosedParentheses () <= 0 ? 0 : endCondition.getClosedParentheses () - 1)));
        PrimeWhereSubExprFinder.concatenateResultWith (result, PrimeWhereSubExprFinder.findSubconds (subConditions,
                startCondition.getOpenedParentheses () <= 0 ? innerStart + 1 : innerStart, endCondition.getClosedParentheses () <= 0 ? innerEnd - 1 : innerEnd, level + 1));
    }
}
