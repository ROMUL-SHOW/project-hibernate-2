package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.City;

import java.util.List;

public class CityDAO {

    public List<City> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<City> query = session.createQuery("from City", City.class);
            return query.list();
        }
    }
    public City findById(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            String hql = "FROM City WHERE id = :id";
            Query<City> query = session.createQuery(hql, City.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }
    public void save(City city) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(city);
            tx.commit();
        }
    }
    public void update(City city) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(city);
            tx.commit();
        }
    }
    public void delete(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            City city = session.get(City.class, id);
            session.delete(city);
            tx.commit();
        }
    }
}