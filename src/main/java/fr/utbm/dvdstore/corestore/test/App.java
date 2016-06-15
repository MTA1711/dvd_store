package fr.utbm.dvdstore.corestore.test;

import fr.utbm.dvdstore.corestore.controller.DefaultFilmController;
import fr.utbm.dvdstore.corestore.dto.FilmDefaultDto;
import fr.utbm.dvdstore.corestore.service.DefaultFilmService;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author java
 */
public class App {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException{
        
        DefaultFilmService s = new DefaultFilmService();
        DefaultFilmController c = new DefaultFilmController();
        FilmDefaultDto f1 ;
        /*
        FilmDefaultDto f1 = new FilmDefaultDto();
        f1.setTitre("Naruto the movie");
        f1.setGenre("mangas");
        f1.setNbExemplaires(50);*/
        f1 = c.recordFilmFromConsoleInput();
        s.recordFilmUsingDefaultDto(f1);
              
    }
}
