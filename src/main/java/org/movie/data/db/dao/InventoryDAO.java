package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.Inventory;

import java.util.List;

public class InventoryDAO {

    public List<Inventory> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Inventory> query = session.createQuery("from Inventory", Inventory.class);
            return query.list();
        }
    }

    public Inventory findById(Integer id) {
        try(Session session = HibernateUtil.getSession()) {
            String hql ="from Inventory WHERE id = :id";
            Query<Inventory> query = session.createQuery(hql, Inventory.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }

    public void save(Inventory inventory) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(inventory);
            tx.commit();
        }
    }

    public void update(Inventory inventory) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(inventory);
            tx.commit();
        }
    }

    public void delete(Integer id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Inventory inventory = session.get(Inventory.class, id);
            session.delete(inventory);
            tx.commit();
        }
    }
}
