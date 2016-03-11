package org.toilelibre.libe.prime;

import java.lang.reflect.Method;
import java.util.UUID;

public class Matcher {

    public static Matcher eq (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        final UUID uuid = ArgsStorage.storeArgs (m.getParameterTypes (), MethodCallRecorder.popCurrentThreadRecordedCallArgs ());
        return new Matcher (PrimeQueryFragmentsBuilder.buildEq (m, uuid, value));
    }

    public static Matcher like (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        final UUID uuid = ArgsStorage.storeArgs (m.getParameterTypes (), MethodCallRecorder.popCurrentThreadRecordedCallArgs ());
        return new Matcher (PrimeQueryFragmentsBuilder.buildLike (m, uuid, value));
    }

    public static Matcher neq (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        final UUID uuid = ArgsStorage.storeArgs (m.getParameterTypes (), MethodCallRecorder.popCurrentThreadRecordedCallArgs ());
        return new Matcher (PrimeQueryFragmentsBuilder.buildNeq (m, uuid, value));
    }

    private final String value;

    private Matcher (final String value) {
        this.value = value;
    }

    public Matcher andEq (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        final UUID uuid = ArgsStorage.storeArgs (m.getParameterTypes (), MethodCallRecorder.popCurrentThreadRecordedCallArgs ());
        return new Matcher (this.value + PrimeQueryFragmentsBuilder.buildAndWhere (PrimeQueryFragmentsBuilder.buildEq (m, uuid, value)));
    }

    public Matcher andLike (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        final UUID uuid = ArgsStorage.storeArgs (m.getParameterTypes (), MethodCallRecorder.popCurrentThreadRecordedCallArgs ());
        return new Matcher (this.value + PrimeQueryFragmentsBuilder.buildAndWhere (PrimeQueryFragmentsBuilder.buildLike (m, uuid, value)));
    }

    public Matcher andNeq (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        final UUID uuid = ArgsStorage.storeArgs (m.getParameterTypes (), MethodCallRecorder.popCurrentThreadRecordedCallArgs ());
        return new Matcher (this.value + PrimeQueryFragmentsBuilder.buildAndWhere (PrimeQueryFragmentsBuilder.buildNeq (m, uuid, value)));
    }

    String getValue () {
        return this.value;
    }

    public Matcher orEq (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        final UUID uuid = ArgsStorage.storeArgs (m.getParameterTypes (), MethodCallRecorder.popCurrentThreadRecordedCallArgs ());
        return new Matcher (this.value + PrimeQueryFragmentsBuilder.buildOrWhere (PrimeQueryFragmentsBuilder.buildEq (m, uuid, value)));
    }

    public Matcher orLike (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        final UUID uuid = ArgsStorage.storeArgs (m.getParameterTypes (), MethodCallRecorder.popCurrentThreadRecordedCallArgs ());
        return new Matcher (this.value + PrimeQueryFragmentsBuilder.buildOrWhere (PrimeQueryFragmentsBuilder.buildLike (m, uuid, value)));
    }

    public Matcher orNeq (final Object o, final Object value) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        final UUID uuid = ArgsStorage.storeArgs (m.getParameterTypes (), MethodCallRecorder.popCurrentThreadRecordedCallArgs ());
        return new Matcher (this.value + PrimeQueryFragmentsBuilder.buildOrWhere (PrimeQueryFragmentsBuilder.buildNeq (m, uuid, value)));
    }
}
