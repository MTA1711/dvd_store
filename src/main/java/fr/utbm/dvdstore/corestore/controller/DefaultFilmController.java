package fr.utbm.dvdstore.corestore.controller;

import fr.utbm.dvdstore.corestore.dto.FilmDefaultDto;
import fr.utbm.dvdstore.corestore.dto.FilmLightDto;
import fr.utbm.dvdstore.corestore.entity.Acteur;
import fr.utbm.dvdstore.corestore.entity.Film;
import fr.utbm.dvdstore.corestore.service.FilmServiceInterface;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author java
 */
@Controller
public class DefaultFilmController {
    
    private FilmServiceInterface filmService ;
    
    public void recordFilmFromConsoleInput(){
        Scanner sc=new Scanner(System.in);
        FilmDefaultDto f1 = new FilmDefaultDto();
        Acteur a1 = new Acteur();        
        
        System.out.println("Quel est le titre du film ?");
        String nom=sc.next();
        System.out.println("Quel est le genre du film ?");
        String genre = sc.next();
        System.out.println("Quel est le nombre d'exemplaire ?");
        Integer nbe = Integer.parseInt(sc.next());
        f1.setTitre(nom);
        f1.setGenre(genre);
        f1.setNbExemplaires(nbe);
        
        System.out.println("Nom acteur principal ?");
        String nomActeur = sc.next();
        System.out.println("Prenom acteur principal ?");
        String prenom  = sc.next();
        a1.setNom(nomActeur);
        a1.setPrenom(prenom);
        f1.setActeurPrincipal(a1);
        
        System.out.println("Combien acteur secondaires");
        Integer nbeSec = Integer.parseInt(sc.next());
        
        if (nbeSec > 0){
            Set<Acteur> list = new HashSet<>();
            for (int j= 1 ; j <=nbeSec ; j++){
                Acteur as = new Acteur();
                System.out.println("Nom acteur secondaire "+ j +" ?" );
                as.setNom(sc.next());
                System.out.println("prenom acteur secondaire "+ j +" ?" );
                as.setPrenom(sc.next());
                list.add(as);
            }
            f1.setActeursSecondaires(list);
        }
        
        filmService.recordFilmUsingDefaultDto(f1);
    }
    
    public void getFilmFromConsoleInput(){
        Scanner sc=new Scanner(System.in);
        Film f1 = null;
        
        System.out.println("Quel est l'identifiant du film ?");      
        Integer nbe = Integer.parseInt(sc.next());       
        f1 = filmService.getFilm(nbe);      
        System.out.println("Film trouvé : ");
        System.out.println(f1);
    }
    
    public void listAllFilmsToConsoleOutput(){
        System.out.println("Liste des films stockés");
        for ( FilmLightDto  f : filmService.getAllFilm() ){
            System.out.println(f.getTitre());
        }
    }

    public FilmServiceInterface getFilmService() {
        return filmService;
    }
    @Autowired
    public void setFilmService(FilmServiceInterface filmService) {
        this.filmService = filmService;
        System.out.println("--> setFilmService() call" );
    }
    
}
