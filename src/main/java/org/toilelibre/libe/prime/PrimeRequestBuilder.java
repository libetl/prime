package org.toilelibre.libe.prime;

import java.lang.reflect.Method;

class PrimeRequestBuilder {

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

}
