package fr.utbm.dvdstore.corestore.repository;

import fr.utbm.dvdstore.corestore.entity.Film;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author java
 */
public class FileFilmDao {

    public void save(Film f) {
        FileWriter writer;
        try {
            writer = new FileWriter("/home/java/dvdstore.txt", true);
            writer.write(f.toString()+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
