package org.movie.data.db.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.movie.data.db.config.HibernateConfig;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
