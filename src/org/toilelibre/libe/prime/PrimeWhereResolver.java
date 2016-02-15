package org.toilelibre.libe.prime;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * Resolves a Tree of DBWhereConditions into a single boolean value
 * To resolve a subcondition tree, issue this instruction :
 * 	DBWhereConditionResolver.findTruth(
 * 		DBWhereConditionResolver.resolve(
 * 			DBWhereConditionDBWhereConditionSubExpressionsFindersFinder.findSubConditions(listOfDbWhereConditions), 
 *          candidate, context).get(0).get(0));
 * @author LBU1
 *
 */
public class PrimeWhereResolver {

	
	/**
	 * Resolves a DBWhereCondition Tree. The subconds input will be altered and will be replaced
	 * by list of true or false dummy dbwhereconditions.
	 * To know if the expression is true, pick the 0th level of the tree and evaluate it. 
	 * @param subconds tree of sub expressions
	 * @param candidate a DBObject to test
	 * @param context the parent DBObject which issued the request
	 * @return the subconds object, modified
	 * @throws CloudException can be thrown inside a DBObject match condition test.
	 */
	public static Map<Integer, List<PrimeWhereSubExprFinder.SubExpression>> resolve(Map<Integer, List<PrimeWhereSubExprFinder.SubExpression>> subconds, Object candidate, Object context) {
		if (candidate == null) {
			return Collections.singletonMap(0, Collections.singletonList(
					new PrimeWhereSubExprFinder.SubExpression (0, 0, Collections.<PrimeWhere>singletonList(
							new PrimeWhere(null, 0, "?", "==", "false", 0) ))));
		}
		
		for (Entry<Integer, List<PrimeWhereSubExprFinder.SubExpression>> level : subconds.entrySet()) {
			resolveLevel (level.getKey(), level.getValue(), candidate, context);
		}

		return subconds;
	}

	private static List<Boolean> resolveLevel(Integer levelNumber, List<PrimeWhereSubExprFinder.SubExpression> levelConds, Object candidate, Object context) {
		List<Boolean> levelBooleans = new ArrayList<Boolean> ();
		for (PrimeWhereSubExprFinder.SubExpression dbwhereconditionList : levelConds) {
			levelBooleans.add(resolveDBWhereConditionsList(dbwhereconditionList, candidate, context));
		}
		return levelBooleans;
	}

	private static boolean resolveDBWhereConditionsList(PrimeWhereSubExprFinder.SubExpression subexpression, Object candidate, Object context) {
		boolean or = true;
		boolean truth = false;
		boolean firstConditionFound = false;
		for (PrimeWhere dbwherecondition : subexpression.getExpressions()) {
			or = !firstConditionFound || !"and".equals (dbwherecondition.getConjunction ());
			firstConditionFound = true;
			truth = "?".equals(dbwherecondition.getExpression ()) ? truth : or ?
					truth || PrimeWhereMatcher.matchesCondition(candidate, dbwherecondition, context) :
						truth && PrimeWhereMatcher.matchesCondition(candidate, dbwherecondition, context);
		}
		for (int i = 0 ; i < subexpression.getExpressions().size() ; i++) {
			if (!"?".equals(subexpression.getExpressions().get (i).getExpression ())) {
				subexpression.getExpressions().set(i, new PrimeWhere(null, 0, "?", "==", "" + truth, 0));
			}
		}
		return truth;
	}

	/**
	 * Evaluates a subExpression filled of dummy DBWhereConditions (true or false only)
	 * @param subexpression the input subexpression
	 * @return the boolean result
	 */
	public static boolean findTruth(PrimeWhereSubExprFinder.SubExpression subexpression) {
		boolean or = true;
		boolean truth = subexpression.getExpressions().isEmpty();
		boolean firstConditionFound = false;
		for (PrimeWhere dbwherecondition : subexpression.getExpressions()) {
			or = !firstConditionFound || !"and".equals (dbwherecondition.getConjunction ());
			firstConditionFound = true;
			truth = or ?
					truth || Boolean.valueOf(dbwherecondition.getValue()) :
						truth && Boolean.valueOf(dbwherecondition.getValue());
		}
		
		return truth;
	}

}
