package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.Language;

import java.util.List;

public class LanguageDAO {

    public List<Language> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Language> query = session.createQuery("from Language", Language.class);
            return query.list();
        }
    }
    public Language findById(Byte id) {
        try(Session session = HibernateUtil.getSession()) {
            String hql = "FROM Language WHERE id = :id";
            Query<Language> query = session.createQuery(hql, Language.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }
    public void save(Language language) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(language);
            tx.commit();
        }
    }
    public void update(Language language) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(language);
            tx.commit();
        }
    }
    public void delete(Byte id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Language language = session.get(Language.class, id);
            session.delete(language);
            tx.commit();
        }
    }
}
