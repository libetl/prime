package org.toilelibre.libe.prime;

import java.lang.reflect.Method;

class MethodCallRecorder {
    private static ThreadLocal<Method> lastMethod = new ThreadLocal<Method> ();

    private static Class<?> getClass (final String className) throws ClassNotFoundException {
        return int.class.getName ().equals (className) ? int.class
                : double.class.getName ().equals (className) ? double.class
                        : float.class.getName ().equals (className) ? float.class
                                : short.class.getName ().equals (className) ? short.class
                                        : long.class.getName ().equals (className) ? long.class
                                                : char.class.getName ().equals (className) ? char.class
                                                        : byte.class.getName ().equals (className) ? byte.class
                                                                : boolean.class.getName ().equals (className) ? boolean.class : Class.forName (className);
    }

    static Method popCurrentThreadRecordedCall () {
        final Method result = MethodCallRecorder.lastMethod.get ();
        MethodCallRecorder.lastMethod.set (null);
        return result;
    }

    public static void recordCall (final String signature) {
        final String argsAsString = signature.substring (signature.indexOf ('(') + 1, signature.lastIndexOf (')'));
        final String classNameAndMethod = signature.substring (0, signature.indexOf ('('));
        final String className = classNameAndMethod.substring (0, classNameAndMethod.lastIndexOf ('.'));
        final String method = classNameAndMethod.substring (classNameAndMethod.lastIndexOf ('.') + 1);

        try {
            final String [] argsofStrings = argsAsString.isEmpty () ? new String [0] : argsAsString.split (",");
            final Class<?> [] args = new Class<?> [argsofStrings.length];
            for (int i = 0 ; i < argsofStrings.length ; i++) {

                args [i] = MethodCallRecorder.getClass (argsofStrings [i]);
            }
            final Class<?> c = Class.forName (className);
            final Method m = c.getDeclaredMethod (method, args);
            MethodCallRecorder.lastMethod.set (m);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace ();
        }
    }
}
