package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.Rental;

import java.util.List;

public class RentalDAO {

    public List<Rental> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Rental> query = session.createQuery("from Rental", Rental.class);
            return query.list();
        }
    }

    public Rental findById(Integer id) {
        try(Session session = HibernateUtil.getSession()) {
            String hql ="from Rental WHERE id = :id";
            Query<Rental> query = session.createQuery(hql, Rental.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }

    public void save(Rental rental) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(rental);
            tx.commit();
        }
    }

    public void update(Rental rental) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(rental);
            tx.commit();
        }
    }

    public void delete(Integer id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Rental rental = session.get(Rental.class, id);
            session.delete(rental);
            tx.commit();
        }
    }
}
