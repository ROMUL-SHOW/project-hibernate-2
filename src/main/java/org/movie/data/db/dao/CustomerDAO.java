package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.Customer;

import java.util.List;

public class CustomerDAO {

    public List<Customer> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Customer> query = session.createQuery("from Customer", Customer.class);
            return query.list();
        }
    }
    public Customer findById(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            return session.find(Customer.class, id);
        }
    }
    public void save(Customer customer) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(customer);
            tx.commit();
        }
    }
    public void update(Customer customer) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(customer);
            tx.commit();
        }
    }
    public void delete(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Customer customer = session.find(Customer.class, id);
            if (customer != null) {
                session.remove(customer);
            }
            tx.commit();
        }
    }
}
