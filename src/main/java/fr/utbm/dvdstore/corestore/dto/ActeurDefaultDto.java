package fr.utbm.dvdstore.corestore.dto;

/**
 *
 * @author java
 */
public class ActeurDefaultDto {
    
    private String nom;
    private String prenom;
    private Integer idActeur;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getIdActeur() {
        return idActeur;
    }

    public void setIdActeur(Integer idActeur) {
        this.idActeur = idActeur;
    }

    @Override
    public String toString() {
        return "ActeurDefaultDto{" + "nom=" + nom + ", prenom=" + prenom + ", idActeur=" + idActeur + '}';
    }
}
