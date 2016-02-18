package org.toilelibre.libe.prime;

import java.lang.reflect.Method;

class PrimeQueryFragmentsBuilder {

    public static String build (final String target, final String where, final int limit, final String listId) {
        return String.format ("select %s where %s limit %d saveAs %s ; ", target, where, limit, listId);
    }

    public static String buildAndWhere (final String value) {
        return " and " + value;
    }

    public static String buildOrWhere (final String value) {
        return " or " + value;
    }

	public static String buildResultListId (String listId) {
		return "resultList ['" + listId + "']";
	}

	public static String buildMethod (Method m) {
		return m.getDeclaringClass ().getName () + "." + m.getName ();
	}

	public static String buildEq (Method m, Object value) {
		return m.getName () + "() == " + value;
	}
	
	public static String buildLike (Method m, Object value) {
		return m.getName () + "() ~= " + value;
	}
	
	public static String buildNeq (Method m, Object value) {
		return m.getName () + "() != " + value;
	}

}
