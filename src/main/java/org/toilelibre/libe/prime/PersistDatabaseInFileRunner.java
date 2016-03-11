package org.toilelibre.libe.prime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.binary.BinaryStreamWriter;

class PersistDatabaseInFileRunner implements Runnable {

    @Override
    public void run () {
        try {
            final File file = Database.getDatabaseFile ();
            if (!file.exists ()) {
                file.createNewFile ();
            }
            final XStream xStream = new XStream ();
            final FileOutputStream fos = new FileOutputStream (file);
            xStream.marshal (Database.getDatabase (), new BinaryStreamWriter (fos));

        } catch (final IOException e) {
            e.printStackTrace ();
        }
    }

}
