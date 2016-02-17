package org.toilelibre.libe.prime;

public interface PrimeQueryConditionSelector<T> extends PrimeQueryReady<T> {

    PrimeQueryConditionSelector<T> and (Matcher matcher);

    PrimeQueryConditionSelector<T> limit (int limit);

    PrimeQueryConditionSelector<T> or (Matcher matcher);
}
