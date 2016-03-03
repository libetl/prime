package org.toilelibre.libe.prime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class PersistDatabaseInFileRunner implements Runnable {

	@Override
	public void run () {
		try {
			File file = Database.getDatabaseFile ();
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream (fos);
			oos.writeObject(Database.getDatabase());
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
