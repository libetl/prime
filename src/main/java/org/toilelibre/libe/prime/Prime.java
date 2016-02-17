package org.toilelibre.libe.prime;

import java.lang.reflect.Method;
import java.util.List;

public class Prime<T> implements PrimeQueryWhereSelector<T>, PrimeQueryConditionSelector<T>, PrimeQueryReady<T> {

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
        return ((List<T>) PrimeQueryExecutor.execute (request));
    }

    public static <T> PrimeQueryWhereSelector<T> select (final Class<T> clazz) {
        return new Prime<T> (clazz);
    }

    public static <T> Prime<T> select (final Object o) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Prime<T> (m);
    }

    private String        target;
    private StringBuilder where;
    private int           limit;
    private String        listId;

    private Prime () {
        this.where = new StringBuilder ();
        this.limit = -1;
    }

    private Prime (final Class<T> clazz) {
        this ();
        this.target = clazz.getName ();
    }

    private Prime (final Method m) {
        this ();
        this.target = m.getDeclaringClass ().getName () + "." + m.getName ();
    }

    @Override
    public PrimeQueryConditionSelector<T> and (final Matcher matcher) {
        this.where.append (PrimeRequestBuilder.buildAndWhere (matcher.getValue ()));
        return this;
    }

    @Override
    public PrimeQueryResultListSelector<T> limit (final int limit) {
        this.limit = limit;
        return this;
    }

    @Override
    @SuppressWarnings ("unchecked")
    public List<T> list () {
        return ((List<T>) PrimeQueryExecutor.execute (PrimeRequestBuilder.build (this.target, this.where.toString (), this.limit, this.listId)));
    }

    @Override
    public PrimeQueryConditionSelector<T> or (final Matcher matcher) {
        this.where.append (PrimeRequestBuilder.buildOrWhere (matcher.getValue ()));
        return this;
    }

    @Override
    public PrimeQueryReady<T> saveAs (final String listId) {
        this.listId = listId;
        return this;
    }

    @Override
    public PrimeQueryConditionSelector<T> where (final Matcher matcher) {
        this.where.append (matcher.getValue ());
        return this;
    }
}
