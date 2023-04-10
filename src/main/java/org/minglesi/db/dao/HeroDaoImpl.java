package org.minglesi.db.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.minglesi.db.HibernateUtil;
import org.minglesi.db.model.Hero;

import java.util.List;


public class HeroDaoImpl implements HeroDao {

    @Override
    public void insert(Hero hero) {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(hero);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Hero hero) {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(hero);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Hero hero = em.getReference(Hero.class, id);
            em.remove(hero);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    @Override
    public void deleteAll() {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Hero").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Hero read(Integer id) {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            return em.find(Hero.class, id);
        } finally {
            em.close();
        }
    }
    @Override
    public List<Hero> readAll() {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            return em.createQuery( " SELECT h FROM Hero h", Hero.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean isNameAvailable(String name) {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            Query query = em.createQuery( " SELECT 1 FROM Hero h WHERE h.name = :name");
            query.setParameter("name", name);
            return query.getResultList().size() == 0;
        } finally {
            em.close();
        }
    }
    
}
