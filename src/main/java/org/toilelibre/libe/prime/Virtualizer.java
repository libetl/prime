package org.toilelibre.libe.prime;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
import javassist.CtNewConstructor;
import javassist.Modifier;
import javassist.NotFoundException;

class Virtualizer {
	private static Map<Class<?>, Object> VIRTUALIZED_CLASSES = new HashMap<Class<?>, Object> ();
	

	@SuppressWarnings("unchecked")
	public static <T> T virtualize (final Class<T> templateClass){
		if (Virtualizer.VIRTUALIZED_CLASSES.get (templateClass) != null) {
			return (T) Virtualizer.VIRTUALIZED_CLASSES.get (templateClass);
		}
        try {

            final ClassPool pool = ClassPool.getDefault ();

            // Create the class.
            final String suffix = UUID.randomUUID ().toString ().replace ('-', '_');
            final CtClass subClass = pool.makeClass (templateClass.getName () + suffix);
            final CtClass superClass = pool.get (templateClass.getName ());
            subClass.setSuperclass (superClass);
            subClass.setModifiers (Modifier.PUBLIC);

            final String params = Virtualizer.getCorrectSuperInvocation (superClass);
            Virtualizer.createEmptyConstructor (templateClass, suffix, subClass, params);
            for (final CtMethod method : superClass.getDeclaredMethods ()) {
            	Virtualizer.setRecordBody (subClass, method);
            }
            Class<?> finalClass = subClass.toClass ();
            T finalObject = (T) finalClass.newInstance ();
            Virtualizer.VIRTUALIZED_CLASSES.put(templateClass, finalObject);
            return finalObject;
        } catch (InstantiationException | IllegalAccessException | CannotCompileException | NotFoundException e) {
            throw new RuntimeException (e);
        }
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

    private static void setRecordBody (final CtClass subClass, final CtMethod method) throws CannotCompileException, NotFoundException {
        final CtMethod subclassedMethod = new CtMethod (method, subClass, null);
        String body = "{" + MethodCallRecorder.class.getName () + ".recordCall(\"" + method.getLongName () + "\");";
        body += "return " + DefaultResponseBuilder.getDefaultResponseForType (method.getReturnType ()) + ";";
        body += "}";
        subclassedMethod.setBody (body);
        subClass.addMethod (subclassedMethod);
    }
}