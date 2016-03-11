package org.toilelibre.libe.prime;

import java.lang.reflect.Method;
import java.util.Set;

public class Prime<T> implements PrimeQueryWhereSelector<T>, PrimeQueryConditionSelector<T>, PrimeQueryReady<T> {

    static {
        // force Database clinit here to trigger the importNow method
        new Database ();
    }

    public static <T> T $ (final Class<T> templateClass) {
        return Virtualizer.virtualize (templateClass);
    }

    @SuppressWarnings ("unchecked")
    public static <T> T $ (final T templateObject) {
        ReferenceRecorder.recordObject (templateObject);
        return (T) Prime.$ (templateObject.getClass ());
    }

    @SuppressWarnings ("unchecked")
    public static <T> Set<T> result (final String request) {
        return ((Set<T>) PrimeQueryExecutor.execute (request));
    }

    public static <T> PrimeQueryWhereSelector<T> select (final Class<T> clazz) {
        return new Prime<T> (clazz);
    }

    public static <T> PrimeQueryWhereSelector<T> select (final Method m) {
        return new Prime<T> (m);
    }

    public static <T> PrimeQueryWhereSelector<T> select (final Object o) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        return new Prime<T> (m);
    }

    public static <T> PrimeQueryWhereSelector<T> select (final String listId1) {
        return new Prime<T> (listId1);
    }

    private String        target;
    private StringBuilder where;
    private int           limit;
    private String        listId;
    private StringBuilder builtQueries;

    private Prime () {
        this.where = new StringBuilder ();
        this.builtQueries = new StringBuilder ();
        this.limit = -1;
    }

    private Prime (final Class<T> clazz) {
        this ();
        this.target = clazz.getName ();
    }

    private Prime (final Class<T> clazz, final String builtQueriesValue) {
        this (clazz);
        this.builtQueries = new StringBuilder (builtQueriesValue);
    }

    private Prime (final Method m) {
        this ();
        this.target = PrimeQueryFragmentsBuilder.buildMethod (m);
    }

    private Prime (final Method m, final String builtQueriesValue) {
        this (m);
        this.builtQueries = new StringBuilder (builtQueriesValue);
    }

    private Prime (final String listId) {
        this ();
        this.target = PrimeQueryFragmentsBuilder.buildResultListId (listId);
    }

    private Prime (final String listId, final String builtQueriesValue) {
        this (listId);
        this.builtQueries = new StringBuilder (builtQueriesValue);
    }

    @Override
    public PrimeQueryConditionSelector<T> and (final Matcher matcher) {
        this.where.append (PrimeQueryFragmentsBuilder.buildAndWhere (matcher.getValue ()));
        return this;
    }

    @Override
    public <U> PrimeQueryWhereSelector<U> andThenSelect (final Class<U> clazz) {
        this.builtQueries.append (PrimeQueryFragmentsBuilder.build (this.target, this.where.toString (), this.limit, this.listId));
        return new Prime<U> (clazz, this.builtQueries.toString ());
    }

    @Override
    public <U> PrimeQueryWhereSelector<U> andThenSelect (final Method m) {
        this.builtQueries.append (PrimeQueryFragmentsBuilder.build (this.target, this.where.toString (), this.limit, this.listId));
        return new Prime<U> (m, this.builtQueries.toString ());
    }

    @Override
    public <U> Prime<U> andThenSelect (final Object o) {
        final Method m = MethodCallRecorder.popCurrentThreadRecordedCall ();
        this.builtQueries.append (PrimeQueryFragmentsBuilder.build (this.target, this.where.toString (), this.limit, this.listId));
        return new Prime<U> (m, this.builtQueries.toString ());
    }

    @Override
    public <U> PrimeQueryWhereSelector<U> andThenSelect (final String listId) {
        this.builtQueries.append (PrimeQueryFragmentsBuilder.build (this.target, this.where.toString (), this.limit, this.listId));
        return new Prime<U> (listId, this.builtQueries.toString ());
    }

    @Override
    public PrimeQueryResultListSelector<T> limit (final int limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public PrimeQueryConditionSelector<T> or (final Matcher matcher) {
        this.where.append (PrimeQueryFragmentsBuilder.buildOrWhere (matcher.getValue ()));
        return this;
    }

    @Override
    @SuppressWarnings ("unchecked")
    public Set<T> result () {
        return ((Set<T>) PrimeQueryExecutor.execute (this.builtQueries + PrimeQueryFragmentsBuilder.build (this.target, this.where.toString (), this.limit, this.listId)));
    }

    @Override
    public PrimeQueryReady<T> saveAs (final String listId) {
        this.listId = listId;
        return this;
    }

    @Override
    public PrimeQueryConditionSelector<T> where (final Matcher matcher) {
        this.where.append (PrimeQueryFragmentsBuilder.buildFirstWhere (matcher.getValue ()));
        return this;
    }
}
