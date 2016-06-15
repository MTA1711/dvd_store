package fr.utbm.dvdstore.corestore.dto;

/**
 * DTO for Film
 * @author java
 */


public class FilmDefaultDto {
    
    private String titre;
    private String genre;
    private Integer nbExemplaires;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getNbExemplaires() {
        return nbExemplaires;
    }

    public void setNbExemplaires(Integer nbExemplaires) {
        this.nbExemplaires = nbExemplaires;
    }

    @Override
    public String toString() {
        return "FilmDefaultDto{" + "titre=" + titre + ", genre=" + genre + ", nbExemplaires=" + nbExemplaires + '}';
    }
    
}
