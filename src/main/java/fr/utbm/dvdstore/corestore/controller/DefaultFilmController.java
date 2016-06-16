package fr.utbm.dvdstore.corestore.controller;

import fr.utbm.dvdstore.corestore.dto.FilmDefaultDto;
import fr.utbm.dvdstore.corestore.entity.Film;
import fr.utbm.dvdstore.corestore.service.DefaultFilmService;
import java.util.Scanner;

/**
 * 
 * @author java
 */
public class DefaultFilmController {
    
    public void recordFilmFromConsoleInput(){
        Scanner sc=new Scanner(System.in);
        FilmDefaultDto f1 = new FilmDefaultDto();
        DefaultFilmService s = new DefaultFilmService();
        
        System.out.println("Quel est le titre du film ?");
        String nom=sc.next();
        System.out.println("Quel est le genre du film ?");
        String genre = sc.next();
        System.out.println("Quel est le nombre d'exemplaire ?");
        Integer nbe = Integer.parseInt(sc.next());
        
        f1.setTitre(nom);
        f1.setGenre(genre);
        f1.setNbExemplaires(nbe);
        s.recordFilmUsingDefaultDto(f1);
    }
    
    public void getFilmFromConsoleInput(){
        Scanner sc=new Scanner(System.in);
        Film f1 = null;
        DefaultFilmService s = new DefaultFilmService();
        
        System.out.println("Quel est l'identifiant du film ?");      
        Integer nbe = Integer.parseInt(sc.next());       
        f1 = s.getFilm(nbe);      
        System.out.println("Film trouvé : ");
        System.out.println(f1);
    }
}
