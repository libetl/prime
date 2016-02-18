package org.toilelibre.libe.prime;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class ArgsStorage {

    private static Map<UUID, Object []> ARGS_STORAGE = new HashMap<UUID, Object []> ();

    static Object [] popArgs (final UUID uuid) {
        return ArgsStorage.ARGS_STORAGE.remove (uuid);
    }

    static UUID storeArgs (final Object [] args) {
        final UUID uuid = UUID.randomUUID ();
        ArgsStorage.ARGS_STORAGE.put (uuid, args);
        return uuid;
    }

}
