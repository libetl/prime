package org.toilelibre.libe.prime;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
import javassist.CtNewConstructor;
import javassist.Modifier;
import javassist.NotFoundException;

public class Prime<T> {

    private StringBuilder request;
    private StringBuilder where;

    public Prime () {
        this.request = new StringBuilder ();
        this.where = new StringBuilder ();
    }
    
    private Prime (Class<T> clazz) {
        this();
        request.append ("temp query bus " + clazz.getName () + " * * limit 10 where \"\" select id dump |;");
    }

    public Prime (Method m) {
        this();
        request.append ("temp query bus " + m.getDeclaringClass().getName() + "." + m.getName() + " * * limit 10 where \"\" select id dump |;");
    }

    public static <T> Prime<T> select (Class<T> clazz) {
        return new Prime<T> (clazz);
    }
    
    public static <T> Prime<T> select (Object o) {
        Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Prime<T> (m);
    }

    @SuppressWarnings ("unchecked")
    public static <T> T $ (T templateObject) {
        ReferenceRecorder.recordObject (templateObject);
        return (T) $ (templateObject.getClass ());
    }

    @SuppressWarnings ("unchecked")
    public static <T> T $ (Class<T> templateClass) {

        try {
            
            ClassPool pool = ClassPool.getDefault ();

            // Create the class.
            String suffix = UUID.randomUUID ().toString ().replace ('-', '_');
            CtClass subClass = pool.makeClass (templateClass.getName () + suffix);
            final CtClass superClass = pool.get (templateClass.getName ());
            subClass.setSuperclass (superClass);
            subClass.setModifiers (Modifier.PUBLIC);

            String params = getCorrectSuperInvocation (superClass);
            createEmptyConstructor (templateClass, suffix, subClass, params);
            for (CtMethod method : superClass.getDeclaredMethods ()) {
                setRecordBody (subClass, method);
            }
            return (T) subClass.toClass ().newInstance ();
        } catch (InstantiationException | IllegalAccessException | CannotCompileException | NotFoundException e) {
            throw new RuntimeException (e);
        }
    }

    private static String getCorrectSuperInvocation (CtClass superClass) throws NotFoundException {
        CtConstructor candidate = null;
        for (CtConstructor constructor : superClass.getConstructors ()) {
            if (candidate == null || constructor.getParameterTypes ().length < candidate.getParameterTypes ().length) {
                candidate = constructor;
            }
        }
        StringBuilder sb = new StringBuilder ();
        for (int i = 0 ; i < candidate.getParameterTypes ().length ; i++) {
            sb.append (DefaultResponseBuilder.getDefaultResponseForType (candidate.getParameterTypes () [i]));
            if (i + 1 < candidate.getParameterTypes ().length) {
                sb.append (",");
            }
        }
        return sb.toString ();
    }

    private static void setRecordBody (CtClass subClass, CtMethod method) throws CannotCompileException, NotFoundException {
        CtMethod subclassedMethod = new CtMethod (method, subClass, null);
        String body = "{" + MethodCallRecorder.class.getName () + ".recordCall(\"" + method.getLongName () + "\");";
        body += "return " + DefaultResponseBuilder.getDefaultResponseForType (method.getReturnType ()) + ";";
        body += "}";
        subclassedMethod.setBody (body);
        subClass.addMethod (subclassedMethod);
    }

    private static <T> void createEmptyConstructor (Class<T> templateClass, String suffix, CtClass subClass, String params) throws CannotCompileException {
        final CtConstructor ctor = CtNewConstructor.make ("public " + templateClass.getSimpleName () + suffix + " () {super(" + params + ");}", subClass);
        subClass.addConstructor (ctor);
    }
    
    // select(AClass.class).where($(AClass.class).isFoo()).and($(AClass.class).isBar())
    // select($(anObject).getThings()).where($(AClass.class).isFoo()).and($(AClass.class).isBar())
    
    public Prime<T> where (Matcher matcher) {
        this.where.append (matcher.getValue ());
        return this;
    }
    
    public Prime<T> and (Matcher matcher) {
        this.where.append (" and " + matcher.getValue ());
        return this;
    }
    
    public Prime<T> or (Matcher matcher) {
        this.where.append (" or " + matcher.getValue ());
        return this;
    }

    @SuppressWarnings ("unchecked")
    public List<T> list () {
        return ((List<T>) ReadPrimeCommand.execute (this.request.toString ().replace ("where \"\"", "where \"" + this.where + "\"")));        
    }
}
