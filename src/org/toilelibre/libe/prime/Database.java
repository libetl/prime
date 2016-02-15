package org.toilelibre.libe.prime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private static Map<Class<?>, List<Object>> database = new HashMap<> ();
    
    public static void store (Object o) {
        if (database.get (o.getClass ()) == null) {
            database.put (o.getClass (), new ArrayList<Object> ());
        }
        database.get (o.getClass ()).add (o);
    }
    @SuppressWarnings("unchecked")
	public static <T> List<T> listType (Class<T> clazz) {
        if (database.get (clazz) == null) {
        	return Collections.emptyList();
        }
        return (List<T>) database.get (clazz);
    }
}
