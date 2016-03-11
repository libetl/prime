package org.toilelibre.libe.prime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.binary.BinaryStreamWriter;

class PersistDatabaseInFileRunner implements Runnable {
    
    @Override
    public void run () {
        try {
            File file = Database.getDatabaseFile ();
            if (!file.exists ()) {
                file.createNewFile ();
            }
            XStream xStream = new XStream ();
            FileOutputStream fos = new FileOutputStream (file);
            xStream.marshal (Database.getDatabase (), new BinaryStreamWriter (fos));
            
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
    
}
