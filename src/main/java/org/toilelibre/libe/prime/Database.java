package org.toilelibre.libe.prime;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Database {

	static {
		Runtime.getRuntime().addShutdownHook(new Thread (new PersistDatabaseInFileRunner ()));
		ImportDatabase.importNow ();
	}
	
    private static Map<Class<?>, Set<Object>> database = new HashMap<> ();

    private static Map<String, Set<Object>> resultSets = new HashMap<> ();

    static Map<Class<?>, Set<Object>> getDatabase () {
    	return new HashMap<> (Database.database);
    }
    
    static void setDatabase ( Map<Class<?>, Set<Object>> database) {
    	Database.database = new HashMap<> (database);
    }
    
    static File getDatabaseFile () {
		URL url = Database.class.getClassLoader().getResource(
				Database.class.getName().replace('.', '/') + ".class");
		String folder = url.getFile().substring(0, url.getFile().indexOf(Database.class.getPackage().getName().replace('.', '/')));
		return new File (folder + "/database.bc");
    }
    
    Database () {}
    
    public static void clear () {
        Database.database.clear ();
        Database.resultSets.clear ();
    }

    @SuppressWarnings ("unchecked")
    public static <T> Set<T> getResultSet (final String SetId) {
        if (Database.resultSets.get (SetId) == null) {
            return Collections.emptySet ();
        }
        return (Set<T>) Collections.unmodifiableSet (Database.resultSets.get (SetId));
    }

    @SuppressWarnings ("unchecked")
    public static <T> Set<T> fetchType (final Class<T> clazz) {
        if (Database.database.get (clazz) == null) {
            return Collections.emptySet ();
        }
        return (Set<T>) Collections.unmodifiableSet (Database.database.get (clazz));
    }

    public static boolean remove (final Object o) {
        if (Database.database.get (o.getClass ()) == null) {
            Database.database.put (o.getClass (), new HashSet<Object> ());
        }
        return Database.database.get (o.getClass ()).remove (o);
    }

    @SuppressWarnings ("unchecked")
    static <T> void saveResultSet (final String SetId, final Class<T> classOfSet, final Set<T> resultSet) {
        Database.resultSets.put (SetId, (Set<Object>) resultSet);
    }

    public static void store (final Object o) {
        if (Database.database.get (o.getClass ()) == null) {
            Database.database.put (o.getClass (), new HashSet<Object> ());
        }
        Database.database.get (o.getClass ()).add (o);
    }

}
