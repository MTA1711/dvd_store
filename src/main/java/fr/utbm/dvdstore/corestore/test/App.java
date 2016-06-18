package fr.utbm.dvdstore.corestore.test;

import fr.utbm.dvdstore.corestore.controller.DefaultFilmController;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author java
 */
public class App {
    public static void main(String[] args){             
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //DefaultFilmController fc = (DefaultFilmController) context.getBean("defaultFilmController"); 
        //fc.recordFilmFromConsoleInput();
    }
}
