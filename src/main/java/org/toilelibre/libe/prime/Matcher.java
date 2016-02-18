package org.toilelibre.libe.prime;

import java.lang.reflect.Method;

public class Matcher {
    public static Matcher eq (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Matcher (PrimeQueryFragmentsBuilder.buildEq (m, value));
    }

    public static Matcher like (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Matcher (PrimeQueryFragmentsBuilder.buildLike (m, value));
    }

    public static Matcher neq (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Matcher (PrimeQueryFragmentsBuilder.buildNeq (m, value));
    }

    private final String value;

    private Matcher (final String value) {
        this.value = value;
    }

    String getValue () {
        return this.value;
    }

}
