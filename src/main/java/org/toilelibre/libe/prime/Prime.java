package org.toilelibre.libe.prime;

import java.lang.reflect.Method;
import java.util.List;

public class Prime<T> {

    public static <T> T $ (final Class<T> templateClass) {
    	return Virtualizer.virtualize (templateClass);
    }

    @SuppressWarnings ("unchecked")
    public static <T> T $ (final T templateObject) {
        ReferenceRecorder.recordObject (templateObject);
        return (T) Prime.$ (templateObject.getClass ());
    }

    @SuppressWarnings ("unchecked")
    public static <T> List<T> list (final String request) {
        return ((List<T>) PrimeCommandReader.execute (request));
    }

    public static <T> Prime<T> select (final Class<T> clazz) {
        return new Prime<T> (clazz);
    }

    public static <T> Prime<T> select (final Object o) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Prime<T> (m);
    }

	private StringBuilder request;
	private StringBuilder where;

	private Prime () {
        this.request = new StringBuilder ();
        this.where = new StringBuilder ();
    }

    private Prime (final Class<T> clazz) {
        this ();
        this.request.append ("select " + clazz.getName () + " limit 10 where \"\";");
    }

    private Prime (final Method m) {
        this ();
        this.request.append ("select " + m.getDeclaringClass ().getName () + "." + m.getName () + " limit 10 where \"\";");
    }


    public Prime<T> and (final Matcher matcher) {
        this.where.append (" and " + matcher.getValue ());
        return this;
    }

    @SuppressWarnings ("unchecked")
    public List<T> list () {
        return ((List<T>) PrimeCommandReader.execute (this.request.toString ().replace ("where \"\"", "where \"" + this.where + "\"")));
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
