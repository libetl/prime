package org.toilelibre.libe.prime;
import java.lang.reflect.Method;


public class MethodCallRecorder {
    private static ThreadLocal<Method> lastMethod = new ThreadLocal<Method> ();
    
    public static void recordCall (String signature) {
        String argsAsString = signature.substring (signature.indexOf ('(') + 1, signature.lastIndexOf (')'));
        String classNameAndMethod = signature.substring (0, signature.indexOf ('('));
        String className = classNameAndMethod.substring (0, classNameAndMethod.lastIndexOf ('.'));
        String method = classNameAndMethod.substring (classNameAndMethod.lastIndexOf ('.') + 1);

        try {
            String [] argsofStrings = argsAsString.isEmpty () ? new String [0] : argsAsString.split (",");
            Class<?> [] args = new Class<?> [argsofStrings.length];
            for (int i = 0 ; i < argsofStrings.length ; i++) {
                
                args [i] = getClass(argsofStrings [i]);
            }
            Class<?> c = Class.forName (className);
            Method m = c.getDeclaredMethod (method, args);
            MethodCallRecorder.lastMethod.set (m);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace ();
        }
    }

    private static Class<?> getClass (String className) throws ClassNotFoundException {
        return int.class.getName ().equals (className) ? int.class :
                    double.class.getName ().equals (className) ? double.class : 
                        float.class.getName ().equals (className) ? float.class :
                            short.class.getName ().equals (className) ? short.class :
                                long.class.getName ().equals (className) ? long.class :
                                    char.class.getName ().equals (className) ? char.class :
                                        byte.class.getName ().equals (className) ? byte.class :
                                            boolean.class.getName ().equals (className) ? boolean.class :  Class.forName (className); 
    }
    
    static Method popCurrentThreadRecordedCall () {
        Method result = MethodCallRecorder.lastMethod.get ();
        MethodCallRecorder.lastMethod.set (null);
        return result;
    }
}
