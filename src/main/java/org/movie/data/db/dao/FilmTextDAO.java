package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.FilmText;

import java.util.List;

public class FilmTextDAO {

    public List<FilmText> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<FilmText> query = session.createQuery("from FilmText", FilmText.class);
            return query.list();
        }
    }

    public FilmText findById(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            String hql ="from FilmText WHERE id = :id";
            Query<FilmText> query = session.createQuery(hql, FilmText.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }

    public void save(FilmText filmText) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(filmText);
            tx.commit();
        }
    }

    public void update(FilmText filmText) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(filmText);
            tx.commit();
        }
    }

    public void delete(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            FilmText filmText = session.get(FilmText.class, id);
            session.delete(filmText);
            tx.commit();
        }
    }
}
