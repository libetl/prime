package org.toilelibre.libe.prime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private static Map<Class<?>, List<Object>> database = new HashMap<> ();

    @SuppressWarnings ("unchecked")
    public static <T> List<T> listType (final Class<T> clazz) {
        if (Database.database.get (clazz) == null) {
            return Collections.emptyList ();
        }
        return (List<T>) Database.database.get (clazz);
    }

    public static void store (final Object o) {
        if (Database.database.get (o.getClass ()) == null) {
            Database.database.put (o.getClass (), new ArrayList<Object> ());
        }
        Database.database.get (o.getClass ()).add (o);
    }
}
