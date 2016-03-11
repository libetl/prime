package org.toilelibre.libe.prime;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.objenesis.ObjenesisHelper;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

class Virtualizer {
    private static Map<Class<?>, Object> VIRTUALIZED_CLASSES = new HashMap<Class<?>, Object> ();

    @SuppressWarnings ("unchecked")
    private static <T> T createProxy (final Class<T> classToMock, final MethodInterceptor interceptor) {
        final Enhancer enhancer = new Enhancer ();
        enhancer.setSuperclass (classToMock);
        enhancer.setCallbackType (interceptor.getClass ());

        final Class<?> proxyClass = enhancer.createClass ();
        Enhancer.registerCallbacks (proxyClass, new Callback [] { interceptor });
        return (T) ObjenesisHelper.newInstance (proxyClass);
    }

    @SuppressWarnings ("unchecked")
    public static <T> T virtualize (final Class<T> templateClass) {
        if (Virtualizer.VIRTUALIZED_CLASSES.get (templateClass) != null) {
            return (T) Virtualizer.VIRTUALIZED_CLASSES.get (templateClass);
        }

        final T virtualizedObject = Virtualizer.createProxy (templateClass, new MethodInterceptor () {

            @Override
            public Object intercept (final Object obj, final Method method, final Object [] args, final MethodProxy proxy) throws Throwable {
                MethodCallRecorder.recordCall (method);
                MethodCallRecorder.recordCallArgs (method.getParameterTypes (), args);
                return DefaultResponseBuilder.getDefaultResponseForType (method.getReturnType ());
            }
        });

        Virtualizer.VIRTUALIZED_CLASSES.put (templateClass, virtualizedObject);
        return virtualizedObject;
    }

}