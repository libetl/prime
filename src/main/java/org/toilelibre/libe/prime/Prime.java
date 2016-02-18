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

    private Prime (final Method m) {
        this ();
        this.target =  PrimeQueryFragmentsBuilder.buildMethod (m);
    }

    private Prime (final String listId) {
        this ();
        this.target = PrimeQueryFragmentsBuilder.buildResultListId (listId);
    }
    
    private Prime (final Class<T> clazz, String builtQueriesValue) {
        this (clazz);
        this.builtQueries = new StringBuilder (builtQueriesValue);
    }

    private Prime (final Method m, String builtQueriesValue) {
        this (m);
        this.builtQueries = new StringBuilder (builtQueriesValue);
    }

    private Prime (final String listId, String builtQueriesValue) {
        this (listId);
        this.builtQueries = new StringBuilder (builtQueriesValue);
    }

    @Override
    public PrimeQueryConditionSelector<T> and (final Matcher matcher) {
        this.where.append (PrimeQueryFragmentsBuilder.buildAndWhere (matcher.getValue ()));
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
        return ((List<T>) PrimeQueryExecutor.execute (this.builtQueries + PrimeQueryFragmentsBuilder.build (this.target, this.where.toString (), this.limit, this.listId)));
    }

    @Override
    public PrimeQueryConditionSelector<T> or (final Matcher matcher) {
        this.where.append (PrimeQueryFragmentsBuilder.buildOrWhere (matcher.getValue ()));
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

	@Override
	public <U> PrimeQueryWhereSelector<U> andThenSelect(final Class<U> clazz) {
		this.builtQueries.append(PrimeQueryFragmentsBuilder.build (this.target, this.where.toString (), this.limit, this.listId));
		return new Prime<U> (clazz, this.builtQueries.toString());
	}

	@Override
	public <U> PrimeQueryWhereSelector<U> andThenSelect(final Method m) {
		this.builtQueries.append(PrimeQueryFragmentsBuilder.build (this.target, this.where.toString (), this.limit, this.listId));
		return new Prime<U> (m, this.builtQueries.toString());
	}
	@Override
	public <U> PrimeQueryWhereSelector<U> andThenSelect(final String listId) {
		this.builtQueries.append(PrimeQueryFragmentsBuilder.build (this.target, this.where.toString (), this.limit, this.listId));
		return new Prime<U> (listId, this.builtQueries.toString());
	}
}
