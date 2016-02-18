package org.toilelibre.libe.prime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private static Map<Class<?>, List<Object>> database = new HashMap<> ();

    private static Map<String, List<Object>> resultLists = new HashMap<> ();

    public static void clear () {
        Database.database.clear ();
        Database.resultLists.clear ();
    }

    @SuppressWarnings ("unchecked")
    public static <T> List<T> getResultList (final String listId) {
        if (Database.resultLists.get (listId) == null) {
            return Collections.emptyList ();
        }
        return (List<T>) Collections.unmodifiableList (Database.resultLists.get (listId));
    }

    @SuppressWarnings ("unchecked")
    public static <T> List<T> listType (final Class<T> clazz) {
        if (Database.database.get (clazz) == null) {
            return Collections.emptyList ();
        }
        return (List<T>) Collections.unmodifiableList (Database.database.get (clazz));
    }

    public static boolean remove (final Object o) {
        if (Database.database.get (o.getClass ()) == null) {
            Database.database.put (o.getClass (), new ArrayList<Object> ());
        }
        return Database.database.get (o.getClass ()).remove (o);
    }

    @SuppressWarnings ("unchecked")
    static <T> void saveResultList (final String listId, final Class<T> classOfList, final List<T> resultList) {
        Database.resultLists.put (listId, (List<Object>) resultList);
    }

    public static void store (final Object o) {
        if (Database.database.get (o.getClass ()) == null) {
            Database.database.put (o.getClass (), new ArrayList<Object> ());
        }
        Database.database.get (o.getClass ()).add (o);
    }

}
