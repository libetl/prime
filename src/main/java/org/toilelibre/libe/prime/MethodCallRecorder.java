package org.toilelibre.libe.prime;

import java.lang.reflect.Method;

class MethodCallRecorder {
    private static ThreadLocal<Method> lastMethod = new ThreadLocal<Method> ();

    private static ThreadLocal<Object []> lastMethodArgs = new ThreadLocal<Object []> ();

    static Method popCurrentThreadRecordedCall () {
        final Method result = MethodCallRecorder.lastMethod.get ();
        MethodCallRecorder.lastMethod.set (null);
        return result;
    }

    static Object [] popCurrentThreadRecordedCallArgs () {
        final Object [] args = MethodCallRecorder.lastMethodArgs.get ();
        MethodCallRecorder.lastMethodArgs.set (null);
        return args;
    }

    public static void recordCall (final Method m) {
        MethodCallRecorder.lastMethod.set (m);
    }

    public static void recordCallArgs (final Class<?> [] paramTypes, final Object [] args) {
        MethodCallRecorder.lastMethodArgs.set (args);
    }

}
