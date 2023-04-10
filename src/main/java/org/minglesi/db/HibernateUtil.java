package org.minglesi.db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static final EntityManagerFactory SESSION_FACTORY;

    static {

        try {
            SESSION_FACTORY = Persistence.createEntityManagerFactory("org.minglesi.persistence");
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManagerFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
