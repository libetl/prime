package org.toilelibre.libe.prime;

public interface PrimeQueryResultListSelector<T> extends PrimeQueryReady<T> {

    PrimeQueryReady<T> saveAs (String listId);

}
