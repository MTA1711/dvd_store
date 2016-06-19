package fr.utbm.dvdstore.corestore.repository;

import fr.utbm.dvdstore.corestore.dto.FilmLightDto;
import fr.utbm.dvdstore.corestore.entity.Film;
import fr.utbm.dvdstore.corestore.util.Converter;
import org.hibernate.Session;
import fr.utbm.dvdstore.corestore.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author java
 */
public class HibernateFilmDao implements FilmDaoInterface{

    public HibernateFilmDao() {
        System.out.println("--> Constructor HibernateFilmDao() call");
    }

    @Override
    public void save(Film f) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(f);
            transaction.commit();
            System.out.println("DAO----> "+f);
        } catch (HibernateException he) {
            if (transaction != null) {
                he.printStackTrace();
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he) {
                    he.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public Film find(int id) {
        Film f = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            f = (Film) session.get(Film.class, id);
            transaction.commit();
            System.out.println("DAO----> "+f);
        } catch (HibernateException he) {
            if (transaction != null) {
                he.printStackTrace();
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he) {
                    he.printStackTrace();
                }
            }
        }
        return f;
    }
    
    @Override
    public List<FilmLightDto> findAll(){
        List<FilmLightDto> listFilmLight = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Film f order by f.titre");
            List<Film> listfilm = query.list();
            transaction.commit();
            
            //Convert Film to Filmlight
            for (Film f : listfilm){
                FilmLightDto l = new FilmLightDto();
                Converter.convert(l, f);
                listFilmLight.add(l);
            }
        } catch (HibernateException he) {
            if (transaction != null) {
                he.printStackTrace();
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he) {
                    he.printStackTrace();
                }
            }
        }
        return listFilmLight;
    }
}
