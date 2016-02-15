package org.toilelibre.libe.prime;
class ReferenceRecorder {
    private static ThreadLocal<Object> lastObject = new ThreadLocal<Object> ();
    static void recordObject (Object object) {
        lastObject.set (object);
    }
    
    
    @SuppressWarnings ("unchecked")
    static <T> T popCurrentThreadRecordedObject () {
        T result = (T) ReferenceRecorder.lastObject.get ();
        ReferenceRecorder.lastObject.set (null);
        return result;
    }
}
