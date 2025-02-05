package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.Payment;

import java.util.List;

public class PaymentDAO {

    public List<Payment> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Payment> query = session.createQuery("from Payment", Payment.class);
            return query.list();
        }
    }

    public Payment findById(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            String hql ="from Payment WHERE id = :id";
            Query<Payment> query = session.createQuery(hql, Payment.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }

    public void save(Payment payment) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(payment);
            tx.commit();
        }
    }

    public void update(Payment payment) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(payment);
            tx.commit();
        }
    }

    public void delete(Short id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Payment payment = session.get(Payment.class, id);
            session.delete(payment);
            tx.commit();
        }
    }
}
