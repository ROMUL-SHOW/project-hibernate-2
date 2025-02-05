package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.Store;

import java.util.List;

public class StoreDAO {

    public List<Store> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Store> query = session.createQuery("from Store", Store.class);
            return query.list();
        }
    }
    public Store findById(Byte id) {
        try(Session session = HibernateUtil.getSession()) {
            String hql = "FROM Store WHERE id = :id";
            Query<Store> query = session.createQuery(hql, Store.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }
    public void save(Store store) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(store);
            tx.commit();
        }
    }
    public void update(Store store) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(store);
            tx.commit();
        }
    }
    public void delete(Byte id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Store store = session.get(Store.class, id);
            session.delete(store);
            tx.commit();
        }
    }
}
