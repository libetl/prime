package org.toilelibre.libe.prime;

public interface PrimeQueryWhereSelector<T> {

    PrimeQueryConditionSelector<T> where (Matcher matcher);
}
