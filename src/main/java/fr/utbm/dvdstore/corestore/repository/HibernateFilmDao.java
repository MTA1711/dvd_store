package fr.utbm.dvdstore.corestore.repository;

import fr.utbm.dvdstore.corestore.entity.Film;
import org.hibernate.Session;
import fr.utbm.dvdstore.corestore.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

/**
 *
 * @author java
 */
public class HibernateFilmDao {

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
    
}
