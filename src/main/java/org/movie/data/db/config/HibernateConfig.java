package org.movie.data.db.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.movie.data.entity.*;

import java.util.Properties;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties prop = new Properties();
                prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                prop.put(Environment.DRIVER, "com.p6spy.engine.spy.P6SpyDriver");
                prop.put(Environment.URL, "jdbc:p6spy:mysql://localhost:3306/movie");
                prop.put(Environment.USER, "root");
                prop.put(Environment.PASS, "root");
                prop.put(Environment.HBM2DDL_AUTO, "update");

                Configuration configuration = new Configuration();
                configuration.setProperties(prop);
                configuration.addAnnotatedClass(Actor.class);
                configuration.addAnnotatedClass(Category.class);
                configuration.addAnnotatedClass(Film.class);
                configuration.addAnnotatedClass(FilmText.class);
                configuration.addAnnotatedClass(Language.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
