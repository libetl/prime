package org.toilelibre.libe.prime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Converts a list of conditions into a tree of nested subconditions map
 * This structure can be more easily resolved than a flat list
 * Example : [ dbwc1 and dbwc2 or (dbwc3 and (dbwc4 or dbwc5)) and dbwc6 ]
 * =>
 *  dbwc1 and  dbwc2 or \____________________________________ and dbwc6
 *                      |
 *                      \_ dbwc3 and \
 *                                   |
 *                                   \_ dbwc4 or dbwc5
 * @author LBU1
 *
 */
public class PrimeWhereSubExprFinder {

	static class SubExpression {
		private int start;
		private int end;
		private List<PrimeWhere> expressions;
		public SubExpression(int start, int end, List<PrimeWhere> expressions) {
			super();
			this.start = start;
			this.end = end;
			this.expressions = expressions;
		}
		public int getStart() {
			return start;
		}
		public int getEnd() {
			return end;
		}
		public List<PrimeWhere> getExpressions() {
			return expressions;
		}
		
	}

	/**
	 * Reads the conditions and transform them into a tree of nested conditions
	 * It uses the openConds and closeConds fields to know if a parenthesis is opened or closed.
	 * @param conditions a flat list of conditions
	 * @return a map of nested conditions
	 */
	public static Map<Integer, List<SubExpression>> findSubConditions(List<PrimeWhere> conditions) {
		if (conditions == null || !pairingIsOk (conditions)) {
			throw new IllegalArgumentException ("Invalid conditions passed in parameters");
		}
		ArrayList<PrimeWhere> conditions2 = new ArrayList<PrimeWhere> (conditions.size());
		for(PrimeWhere condition: conditions)
			try {
				conditions2.add((PrimeWhere)condition.clone());
			} catch (CloneNotSupportedException e) {
			}
		Map<Integer, List<SubExpression>> result = new TreeMap<> (Collections.reverseOrder());
		concatenateResultWith(result, PrimeWhereSubExprFinder.findSubconds(conditions2, 0, conditions.size() - 1, 0));
		addToResult(conditions2, 0, result, 0, Math.max(0, conditions.size() - 1));
		return result;
	}

	private static boolean pairingIsOk(List<PrimeWhere> conditions) {
		if (conditions.isEmpty()) {
			return true;
		}
		int level = 0;
		for (int i = 0 ; i < conditions.size() ; i++) {
			level += conditions.get(i).getOpenedParentheses ();
			level -= conditions.get(i).getClosedParentheses ();
			if (level < 0) {
				return false;
			}
		}
		return true;
	}

	private static Map<Integer, List<SubExpression>> findSubconds(List<PrimeWhere> conditions, int start, int end, int level) {
		if (start >= end) {
			return Collections.emptyMap();
		}
		Map<Integer, List<SubExpression>> result = new TreeMap<>();
		int nestedLevel = 0;
		int innerStart = 0;
		int innerEnd = 0;
		for (int i = start; i <= end; i++) {
			PrimeWhere thisCondition = conditions.get(i);
			switch (thisCondition.getOpenedParentheses ()) {
			case 0:break;
			default:
				if (nestedLevel == 0) {
					innerStart = i;
				}
				nestedLevel+= thisCondition.getOpenedParentheses ();
				break;
			}
			switch (thisCondition.getClosedParentheses ()) {
			case 0:break;
			default:
				nestedLevel-= thisCondition.getClosedParentheses ();
				if (nestedLevel <= 0) {
					innerEnd = i;
					restartSameScopeNestedOnce(conditions, level, result, innerStart, innerEnd);
				}
				break;
			}
		}
		return result;
	}

	private static void restartSameScopeNestedOnce(List<PrimeWhere> conditions, int level, Map<Integer, List<SubExpression>> result, int innerStart,
			int innerEnd) {
		List<PrimeWhere> subConditions= new ArrayList<> (conditions);
		PrimeWhere startCondition = conditions.get(innerStart);
		PrimeWhere endCondition = conditions.get(innerEnd);
		addToResult(conditions, level + 1, result, innerStart, innerEnd);
		subConditions.set(innerStart, new PrimeWhere (startCondition.getConjunction (),
		        (startCondition.getOpenedParentheses () <= 0 ? 0 : startCondition.getOpenedParentheses() - 1),
		        startCondition.getExpression (), startCondition.getOperator (), startCondition.getValue (),
				startCondition.getClosedParentheses ()));
		subConditions.set(innerEnd, new PrimeWhere (endCondition.getConjunction (), endCondition.getOpenedParentheses (), endCondition.getExpression (), 
		        endCondition.getOperator (), endCondition.getValue (), 
				(endCondition.getClosedParentheses () <= 0 ? 0 : endCondition.getClosedParentheses() - 1)));
		concatenateResultWith(result, PrimeWhereSubExprFinder.findSubconds(subConditions, startCondition.getOpenedParentheses () <= 0 ? innerStart + 1 : innerStart, 
																		endCondition.getClosedParentheses () <= 0 ? innerEnd - 1 : innerEnd, level + 1));
	}

	private static void concatenateResultWith(Map<Integer, List<SubExpression>> result, Map<Integer, List<SubExpression>> additions) {
		result.putAll(additions);
	}

	private static void addToResult(List<PrimeWhere> conditions, int level, Map<Integer, List<SubExpression>> result, int innerStart, int innerEnd) {
		if (result.get(level) == null) {
			result.put(level, new LinkedList<SubExpression>());
		}
		List<PrimeWhere> subList = conditions.subList(innerStart, Math.min(innerEnd + 1, conditions.size()));
		result.get(level).add(new SubExpression(innerStart, innerEnd, subList));
	}
}
