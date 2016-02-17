package org.toilelibre.libe.prime;

public interface PrimeQueryConditionSelector<T> extends PrimeQueryReady<T>, PrimeQueryResultListSelector<T> {

    PrimeQueryConditionSelector<T> and (Matcher matcher);

    PrimeQueryResultListSelector<T> limit (int limit);

    PrimeQueryConditionSelector<T> or (Matcher matcher);
}
