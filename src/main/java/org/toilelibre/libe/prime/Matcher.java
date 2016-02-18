package org.toilelibre.libe.prime;

import java.lang.reflect.Method;
import java.util.UUID;

public class Matcher {

    public static Matcher eq (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        final UUID uuid = ArgsStorage.storeArgs (MethodCallRecorder.popCurrentThreadRecordedCallArgs ());
        return new Matcher (PrimeQueryFragmentsBuilder.buildEq (m, uuid, value));
    }

    public static Matcher like (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        final UUID uuid = ArgsStorage.storeArgs (MethodCallRecorder.popCurrentThreadRecordedCallArgs ());
        return new Matcher (PrimeQueryFragmentsBuilder.buildLike (m, uuid, value));
    }

    public static Matcher neq (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        final UUID uuid = ArgsStorage.storeArgs (MethodCallRecorder.popCurrentThreadRecordedCallArgs ());
        return new Matcher (PrimeQueryFragmentsBuilder.buildNeq (m, uuid, value));
    }

    private final String value;

    private Matcher (final String value) {
        this.value = value;
    }

    String getValue () {
        return this.value;
    }
}
