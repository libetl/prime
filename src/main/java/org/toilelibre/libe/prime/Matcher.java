package org.toilelibre.libe.prime;

import java.lang.reflect.Method;

public class Matcher {
    public static Matcher eq (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Matcher (m.getName () + "() == " + value);
    }

    public static Matcher like (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Matcher (m.getName () + "() ~~ " + value);
    }

    public static Matcher neq (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Matcher (m.getName () + "() != " + value);
    }

    private final String value;

    private Matcher (final String value) {
        this.value = value;
    }

    String getValue () {
        return this.value;
    }

}
