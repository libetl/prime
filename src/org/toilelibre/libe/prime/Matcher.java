package org.toilelibre.libe.prime;

import java.lang.reflect.Method;

public class Matcher {
    private String value;
    private Matcher (String value) {
        this.value = value;
    }
    
    public static Matcher eq (Object o, Object value) {
        Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Matcher (m.getName () + "() == " + value);
    }
    
    public static Matcher neq (Object o, Object value) {
        Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Matcher (m.getName () + "() != " + value);
    }
    public static Matcher like (Object o, Object value) {
        Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Matcher (m.getName () + "() ~~ " + value);
    }

    String getValue () {
        return value;
    }
    
}

