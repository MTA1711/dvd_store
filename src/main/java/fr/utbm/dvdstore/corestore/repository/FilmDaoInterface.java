package fr.utbm.dvdstore.corestore.repository;

import fr.utbm.dvdstore.corestore.dto.FilmLightDto;
import fr.utbm.dvdstore.corestore.entity.Film;
import java.util.List;

/**
 * Contract that has to be signed by all FilmDao classes
 * @author java
 */
public interface FilmDaoInterface {
    /**
     * Save a film in database
     * @param f 
     */
    public void save(Film f);
    /**
     * find a film by id
     * @param id
     * @return Film
     */
    public Film find(int id);
    /**
     * Get all films in DB
     * @return 
     */
    public List<FilmLightDto> findAll();
}
