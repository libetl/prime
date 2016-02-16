package org.toilelibre.libe.prime;

class ReferenceRecorder {
    private static ThreadLocal<Object> lastObject = new ThreadLocal<Object> ();

    @SuppressWarnings ("unchecked")
    static <T> T popCurrentThreadRecordedObject () {
        final T result = (T) ReferenceRecorder.lastObject.get ();
        ReferenceRecorder.lastObject.set (null);
        return result;
    }

    static void recordObject (final Object object) {
        ReferenceRecorder.lastObject.set (object);
    }
}
