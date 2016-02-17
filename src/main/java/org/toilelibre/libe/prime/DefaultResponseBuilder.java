package org.toilelibre.libe.prime;

import java.util.Arrays;


class DefaultResponseBuilder {

    public static Object getDefaultResponseForType (final Class<?> returnType) {
        if (Arrays.asList (int.class, byte.class, char.class, double.class, float.class, int.class, long.class, short.class)
                .contains (returnType)) {
            return 0;
        }
        if (returnType == boolean.class || returnType == Boolean.class) {
            return false;
        }
        if (returnType == String.class) {
            return "";
        }
        return null;
    }

}
