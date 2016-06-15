package fr.utbm.dvdstore.corestore.controller;

import fr.utbm.dvdstore.corestore.dto.FilmDefaultDto;
import java.util.Scanner;

/**
 * 
 * @author java
 */
public class DefaultFilmController {
    
    public FilmDefaultDto recordFilmFromConsoleInput(){
        Scanner sc=new Scanner(System.in);
        FilmDefaultDto f1 = new FilmDefaultDto();
        
        System.out.println("Quel est le titre du film ?");
        String nom=sc.next();
        System.out.println("Quel est le genre du film ?");
        String genre = sc.next();
        System.out.println("Quel est le nombre d'exemplaire ?");
        Integer nbe = Integer.parseInt(sc.next());
        
        f1.setTitre(nom);
        f1.setGenre(genre);
        f1.setNbExemplaires(nbe);
        
        return f1;
    }
}
