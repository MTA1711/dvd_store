package fr.utbm.dvdstore.corestore.service;

import fr.utbm.dvdstore.corestore.dto.FilmDefaultDto;
import fr.utbm.dvdstore.corestore.dto.FilmLightDto;
import fr.utbm.dvdstore.corestore.entity.Film;
import fr.utbm.dvdstore.corestore.repository.FilmDaoInterface;
import fr.utbm.dvdstore.corestore.util.Converter;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DefaultFilmService implements FilmServiceInterface{
    //@Resource
    //@Autowired
    private FilmDaoInterface filmDao ;
    
    public DefaultFilmService(){
        
    }
    
    public DefaultFilmService(FilmDaoInterface filmDao) {
        this.filmDao = filmDao;
        System.out.println("--> constructoc DefaultFilmService(FilmDaoInterface filmDao) call");
    }
    
    public FilmDaoInterface getFilmDao() {
        return filmDao;
    }
    //@Resource (name="filmRepository")
    @Autowired
    public void setFilmDao(FilmDaoInterface filmDao) {
        this.filmDao = filmDao;
        System.out.println("--> setFilmDao call");
    }
    
    @Override
    public void recordFilmUsingDefaultDto(FilmDefaultDto filmDto) {
        Film f = new Film();        
        //convert dto to bean
        Converter.convert(f, filmDto);
        System.out.println(f);
        filmDao.save(f);
    }
    
    @Override
    public Film getFilm (int id){
        Film f = null;
        f = filmDao.find(id);
        return f;
    }
    
    @Override
    public List<FilmLightDto> getAllFilm(){
        return filmDao.findAll();
    }
}
