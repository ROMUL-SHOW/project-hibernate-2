package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.Address;

import java.util.List;

public class AddressDAO {

    public List<Address> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Address> query = session.createQuery("from Address", Address.class);
            return query.list();
        }
    }
    public Address findById(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            String hql = "FROM Address WHERE id = :id";
            Query<Address> query = session.createQuery(hql, Address.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }
    public void save(Address address) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(address);
            tx.commit();
        }
    }
    public void update(Address address) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(address);
            tx.commit();
        }
    }
    public void delete(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Address address = session.get(Address.class, id);
            session.delete(address);
            tx.commit();
        }
    }
}
