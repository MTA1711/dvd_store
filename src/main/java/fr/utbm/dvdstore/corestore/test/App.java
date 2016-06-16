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
               
        DefaultFilmController c = new DefaultFilmController();
        c.recordFilmFromConsoleInput();                 
    }
}
