package fr.utbm.dvdstore.corestore.entity;

import java.util.Set;

/**
 * Represent a film
 * @author java
 */
public class Film {
    
    private String titre;
    private String genre;
    private Integer nbExemplaires;
    private Acteur acteurPrincipal;
    private Set<Acteur> acteursSecondaires;
    private Integer idFilm;

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }
    
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

    public Acteur getActeurPrincipal() {
        return acteurPrincipal;
    }

    public void setActeurPrincipal(Acteur acteurPrincipal) {
        this.acteurPrincipal = acteurPrincipal;
    }

    public Set<Acteur> getActeursSecondaires() {
        return acteursSecondaires;
    }

    public void setActeursSecondaires(Set<Acteur> acteursSecondaires) {
        this.acteursSecondaires = acteursSecondaires;
    }

    @Override
    public String toString() {
        String ac2 = "";
        int i = 0;
        if ( acteursSecondaires != null ){
            for (Acteur a : acteursSecondaires){
                if (i == 0){
                    ac2 += a.toString();
                }else{
                    ac2 += ", " + a.toString();
                }          
            }
        }
        return "Film{ID=" + idFilm + ", titre=" + titre + ", genre=" + genre + ", nbExemplaires=" + nbExemplaires + ", acteurPrincipal=" + acteurPrincipal + ", acteursSecondaires="+ac2+ '}';
    }    
    
}
