package fr.utbm.dvdstore.corestore.service;

import fr.utbm.dvdstore.corestore.dto.FilmDefaultDto;
import fr.utbm.dvdstore.corestore.entity.Film;
import fr.utbm.dvdstore.corestore.repository.JdbcFilmDao;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;



public class DefaultFilmService {
    
    public void recordFilmUsingDefaultDto(FilmDefaultDto filmDto) throws IllegalAccessException, InvocationTargetException{
        //System.out.println(filmDto);
        JdbcFilmDao r = new JdbcFilmDao();
        Film f = new Film();
        //convert dto to bean
        BeanUtils.copyProperties(f, filmDto);
        System.out.println(f);
        r.save(f);
    }
}
