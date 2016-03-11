package org.toilelibre.libe.prime;

import java.lang.reflect.Method;
import java.util.Set;

public interface PrimeQueryReady<T> {

    <U> PrimeQueryWhereSelector<U> andThenSelect (Class<U> clazz);

    <U> PrimeQueryWhereSelector<U> andThenSelect (Method m);

    <U> PrimeQueryWhereSelector<U> andThenSelect (Object methodCallResult);

    <U> PrimeQueryWhereSelector<U> andThenSelect (String listId);

    Set<T> result ();
}
