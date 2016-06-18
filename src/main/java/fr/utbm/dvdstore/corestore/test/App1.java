package fr.utbm.dvdstore.corestore.test;

import fr.utbm.dvdstore.corestore.controller.DefaultFilmController;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author java
 */
public class App1 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException{
        
        DefaultFilmController c = new DefaultFilmController();
        c.getFilmFromConsoleInput();              
    }
}
