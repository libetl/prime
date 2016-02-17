package org.toilelibre.libe.prime;

import java.lang.reflect.Method;

class MethodCallRecorder {
    private static ThreadLocal<Method> lastMethod = new ThreadLocal<Method> ();

    static Method popCurrentThreadRecordedCall () {
        final Method result = MethodCallRecorder.lastMethod.get ();
        MethodCallRecorder.lastMethod.set (null);
        return result;
    }

    public static void recordCall (final Method m) {
    	MethodCallRecorder.lastMethod.set (m);
    }
}
