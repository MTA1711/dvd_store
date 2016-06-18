package fr.utbm.dvdstore.corestore.service;

import fr.utbm.dvdstore.corestore.dto.FilmDefaultDto;
import fr.utbm.dvdstore.corestore.dto.FilmLightDto;
import fr.utbm.dvdstore.corestore.entity.Film;
import fr.utbm.dvdstore.corestore.repository.HibernateFilmDao;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.BeanUtils;



public class DefaultFilmService {
    
    public void recordFilmUsingDefaultDto(FilmDefaultDto filmDto) {
        //System.out.println(filmDto);
        HibernateFilmDao h = new HibernateFilmDao();
        Film f = new Film();
        try {
            //convert dto to bean
            BeanUtils.copyProperties(f, filmDto);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DefaultFilmService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DefaultFilmService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(f);
        h.save(f);
    }
    
    public Film getFilm (int id){
        Film f = null;
        HibernateFilmDao h = new HibernateFilmDao();
        f = h.find(id);
        return f;
    }
    
    public List<FilmLightDto> getAllFilm(){
        HibernateFilmDao h = new HibernateFilmDao();
        return h.findAll();
    }
}
