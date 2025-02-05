package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.Country;

import java.util.List;

public class CountryDAO {

    public List<Country> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Country> query = session.createQuery("from Country", Country.class);
            return query.list();
        }
    }
    public Country findById(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            String hql = "FROM Country WHERE id = :id";
            Query<Country> query = session.createQuery(hql, Country.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }
    public void save(Country country) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(country);
            tx.commit();
        }
    }
    public void update(Country country) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(country);
            tx.commit();
        }
    }
    public void delete(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Country country = session.get(Country.class, id);
            session.delete(country);
            tx.commit();
        }
    }

}
