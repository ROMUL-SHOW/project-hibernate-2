package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.entity.Film;
import org.movie.data.db.util.HibernateUtil;
import java.util.List;

public class FilmDAO {

    public List<Film> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Film> query = session.createQuery("from Film", Film.class);
            return query.list();
        }
    }

    public Film findById(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            String hql ="from Film WHERE id = :id";
            Query<Film> query = session.createQuery(hql, Film.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }

    public void save(Film film) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(film);
            tx.commit();
        }
    }

    public void update(Film film) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(film);
            tx.commit();
        }
    }

    public void delete(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Film film = session.get(Film.class, id);
            session.delete(film);
            tx.commit();
        }
    }
}
