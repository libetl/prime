package org.toilelibre.libe.prime;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

class ImportDatabase {

	public static void importNow () {
		try {
			File file = Database.getDatabaseFile ();
			if (!file.exists()) {
				file.createNewFile();
			}
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream (fis);
			@SuppressWarnings("unchecked")
			Map<Class<?>, Set<Serializable>> database = (Map<Class<?>, Set<Serializable>>) ois.readObject();
			ois.close();
			Database.setDatabase(database);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
