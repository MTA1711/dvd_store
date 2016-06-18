package fr.utbm.dvdstore.corestore.dto;

/**
 * DTO light for Film
 * @author java
 */


public class FilmLightDto {
    
    private String titre;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "FilmLightDto{" + "titre=" + titre + '}';
    }
        
}
