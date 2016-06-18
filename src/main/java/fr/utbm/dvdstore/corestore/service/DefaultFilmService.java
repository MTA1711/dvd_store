package fr.utbm.dvdstore.corestore.service;

import fr.utbm.dvdstore.corestore.dto.FilmDefaultDto;
import fr.utbm.dvdstore.corestore.dto.FilmLightDto;
import fr.utbm.dvdstore.corestore.entity.Film;
import fr.utbm.dvdstore.corestore.repository.HibernateFilmDao;
import fr.utbm.dvdstore.corestore.util.Converter;
import java.util.List;



public class DefaultFilmService implements FilmServiceInterface{
    @Override
    public void recordFilmUsingDefaultDto(FilmDefaultDto filmDto) {
        //System.out.println(filmDto);
        HibernateFilmDao h = new HibernateFilmDao();
        Film f = new Film();        
        //convert dto to bean
        Converter.convert(f, filmDto);
        System.out.println(f);
        h.save(f);
    }
    
    @Override
    public Film getFilm (int id){
        Film f = null;
        HibernateFilmDao h = new HibernateFilmDao();
        f = h.find(id);
        return f;
    }
    
    @Override
    public List<FilmLightDto> getAllFilm(){
        HibernateFilmDao h = new HibernateFilmDao();
        return h.findAll();
    }
}
