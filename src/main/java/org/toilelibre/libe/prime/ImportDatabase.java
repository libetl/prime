package org.toilelibre.libe.prime;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.binary.BinaryStreamReader;

class ImportDatabase {

	@SuppressWarnings ("unchecked")
    public static void importNow () {

        try {
            File file = Database.getDatabaseFile ();
            if (!file.exists ()) {
                file.createNewFile ();
                return;
            }
            XStream xStream = new XStream ();
            FileInputStream fis = new FileInputStream (file);
            Database.setDatabase (
                    (Map<Class<?>, Set<Object>>) 
                    xStream.unmarshal (new BinaryStreamReader (fis)));
            
        } catch (IOException e) {
            e.printStackTrace ();
        }
	}

}
