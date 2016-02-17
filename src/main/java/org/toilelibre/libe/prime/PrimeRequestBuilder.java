package org.toilelibre.libe.prime;

public class PrimeRequestBuilder {

    public static String build (final String target, final String where, final int limit) {
        return String.format ("select %s where %s limit %d", target, where, limit);
    }

}
