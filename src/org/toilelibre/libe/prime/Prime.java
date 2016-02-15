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

    @SuppressWarnings ("unchecked")
    public static <T> T $ (final Class<T> templateClass) {

        try {

            final ClassPool pool = ClassPool.getDefault ();

            // Create the class.
            final String suffix = UUID.randomUUID ().toString ().replace ('-', '_');
            final CtClass subClass = pool.makeClass (templateClass.getName () + suffix);
            final CtClass superClass = pool.get (templateClass.getName ());
            subClass.setSuperclass (superClass);
            subClass.setModifiers (Modifier.PUBLIC);

            final String params = Prime.getCorrectSuperInvocation (superClass);
            Prime.createEmptyConstructor (templateClass, suffix, subClass, params);
            for (final CtMethod method : superClass.getDeclaredMethods ()) {
                Prime.setRecordBody (subClass, method);
            }
            return (T) subClass.toClass ().newInstance ();
        } catch (InstantiationException | IllegalAccessException | CannotCompileException | NotFoundException e) {
            throw new RuntimeException (e);
        }
    }

    @SuppressWarnings ("unchecked")
    public static <T> T $ (final T templateObject) {
        ReferenceRecorder.recordObject (templateObject);
        return (T) Prime.$ (templateObject.getClass ());
    }

    private static <T> void createEmptyConstructor (final Class<T> templateClass, final String suffix, final CtClass subClass, final String params) throws CannotCompileException {
        final CtConstructor ctor = CtNewConstructor.make ("public " + templateClass.getSimpleName () + suffix + " () {super(" + params + ");}", subClass);
        subClass.addConstructor (ctor);
    }

    private static String getCorrectSuperInvocation (final CtClass superClass) throws NotFoundException {
        CtConstructor candidate = null;
        for (final CtConstructor constructor : superClass.getConstructors ()) {
            if ( (candidate == null) || (constructor.getParameterTypes ().length < candidate.getParameterTypes ().length)) {
                candidate = constructor;
            }
        }
        final StringBuilder sb = new StringBuilder ();
        for (int i = 0 ; i < candidate.getParameterTypes ().length ; i++) {
            sb.append (DefaultResponseBuilder.getDefaultResponseForType (candidate.getParameterTypes () [i]));
            if ( (i + 1) < candidate.getParameterTypes ().length) {
                sb.append (",");
            }
        }
        return sb.toString ();
    }

    @SuppressWarnings ("unchecked")
    public static <T> List<T> list (final String request) {
        return ((List<T>) ReadPrimeCommand.execute (request + (request.endsWith (";") ? "" : ";")));
    }

    public static <T> Prime<T> select (final Class<T> clazz) {
        return new Prime<T> (clazz);
    }

    public static <T> Prime<T> select (final Object o) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Prime<T> (m);
    }

    private static void setRecordBody (final CtClass subClass, final CtMethod method) throws CannotCompileException, NotFoundException {
        final CtMethod subclassedMethod = new CtMethod (method, subClass, null);
        String body = "{" + MethodCallRecorder.class.getName () + ".recordCall(\"" + method.getLongName () + "\");";
        body += "return " + DefaultResponseBuilder.getDefaultResponseForType (method.getReturnType ()) + ";";
        body += "}";
        subclassedMethod.setBody (body);
        subClass.addMethod (subclassedMethod);
    }

    private StringBuilder request;

    private StringBuilder where;

    public Prime () {
        this.request = new StringBuilder ();
        this.where = new StringBuilder ();
    }

    private Prime (final Class<T> clazz) {
        this ();
        this.request.append ("select " + clazz.getName () + " limit 10 where \"\";");
    }

    public Prime (final Method m) {
        this ();
        this.request.append ("select " + m.getDeclaringClass ().getName () + "." + m.getName () + " limit 10 where \"\";");
    }

    // select(AClass.class).where($(AClass.class).isFoo()).and($(AClass.class).isBar())
    // select($(anObject).getThings()).where($(AClass.class).isFoo()).and($(AClass.class).isBar())

    public Prime<T> and (final Matcher matcher) {
        this.where.append (" and " + matcher.getValue ());
        return this;
    }

    @SuppressWarnings ("unchecked")
    public List<T> list () {
        return ((List<T>) ReadPrimeCommand.execute (this.request.toString ().replace ("where \"\"", "where \"" + this.where + "\"")));
    }

    public Prime<T> or (final Matcher matcher) {
        this.where.append (" or " + matcher.getValue ());
        return this;
    }

    public Prime<T> where (final Matcher matcher) {
        this.where.append (matcher.getValue ());
        return this;
    }
}
