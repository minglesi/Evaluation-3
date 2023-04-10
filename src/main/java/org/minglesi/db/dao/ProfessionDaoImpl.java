package org.minglesi.db.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.minglesi.db.HibernateUtil;
import org.minglesi.db.model.Profession;

import java.util.List;

public class ProfessionDaoImpl implements ProfessionDao {

    @Override
    public Profession insert(Profession profession) {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(profession);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return profession;
    }

    @Override
    public List<Profession> readAll() {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            return em.createQuery( " SELECT p FROM Profession p", Profession.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean isValidProfessionId(Long professionId) {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            Query query = em.createQuery( " SELECT 1 FROM Profession p WHERE p.id = :professionId");
            query.setParameter("professionId", professionId);
            return query.getResultList().size() > 0;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean isNameAvailable(String name) {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            Query query = em.createQuery( " SELECT 1 FROM Profession p WHERE p.name = :name");
            query.setParameter("name", name);
            return query.getResultList().size() == 0;
        } finally {
            em.close();
        }
    }
}
