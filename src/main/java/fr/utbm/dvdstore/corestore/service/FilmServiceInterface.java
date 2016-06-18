package fr.utbm.dvdstore.corestore.service;

import fr.utbm.dvdstore.corestore.dto.FilmDefaultDto;
import fr.utbm.dvdstore.corestore.dto.FilmLightDto;
import fr.utbm.dvdstore.corestore.entity.Film;
import java.util.List;

/**
 * Contract that has to be signed by all FilmService classes
 * @author java
 */
public interface FilmServiceInterface {
    /**
     * Record a movie using default film DTO
     * @param filmDto 
     */
    public void recordFilmUsingDefaultDto(FilmDefaultDto filmDto);
    /**
     * Retrieve a movie stored in DB using its ID
     * @param id
     * @return 
     */
    public Film getFilm (int id);
    /**
     * Retrieve all movies in DB
     * @return  list of movies. Films are in light version
     */
    public List<FilmLightDto> getAllFilm();
}
