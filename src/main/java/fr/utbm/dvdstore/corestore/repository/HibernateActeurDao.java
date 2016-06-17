package fr.utbm.dvdstore.corestore.repository;

import fr.utbm.dvdstore.corestore.entity.Acteur;
import fr.utbm.dvdstore.corestore.entity.Film;
import org.hibernate.Session;
import fr.utbm.dvdstore.corestore.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

/**
 *
 * @author java
 */
public class HibernateActeurDao {

    public void save(Acteur c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(c);
            transaction.commit();
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
    
    public Acteur find(int id) {
        Acteur f = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            f = (Acteur) session.get(Acteur.class, id);
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
