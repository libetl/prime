package org.toilelibre.libe.prime;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class ArgsStorage {

    private static Map<UUID, Object []> ARGS_STORAGE = new HashMap<UUID, Object []> ();
    private static Map<UUID, Class<?> []> PARAM_TYPES_STORAGE =  new HashMap<UUID, Class<?> []> ();

    static Object [] popArgs (final UUID uuid) {
        return ArgsStorage.ARGS_STORAGE.remove (uuid);
    }

    static UUID storeArgs (final Class<?> [] paramTypes, Object [] args) {
        final UUID uuid = UUID.randomUUID ();
        ArgsStorage.PARAM_TYPES_STORAGE.put (uuid, paramTypes);
        ArgsStorage.ARGS_STORAGE.put (uuid, args);
        return uuid;
    }

	public static Class<?>[] popParamTypes(UUID uuid) {
        return ArgsStorage.PARAM_TYPES_STORAGE.remove (uuid);
	}

}
