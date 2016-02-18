package org.toilelibre.libe.prime;

import java.lang.reflect.Method;
import java.util.List;

public interface PrimeQueryReady<T> {

    List<T> list ();
    <U> PrimeQueryWhereSelector<U> andThenSelect (Class<U> clazz);
    <U> PrimeQueryWhereSelector<U> andThenSelect (Method m);
    <U> PrimeQueryWhereSelector<U> andThenSelect (String listId);
}
