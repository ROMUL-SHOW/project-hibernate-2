package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.Staff;

import java.util.List;

public class StaffDAO {

    public List<Staff> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Staff> query = session.createQuery("from Staff", Staff.class);
            return query.list();
        }
    }
    public Staff findById(Byte id) {
        try(Session session = HibernateUtil.getSession()) {
            String hql = "FROM Staff WHERE id = :id";
            Query<Staff> query = session.createQuery(hql, Staff.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }
    public void save(Staff staff) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(staff);
            tx.commit();
        }
    }
    public void update(Staff staff) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(staff);
            tx.commit();
        }
    }
    public void delete(Byte id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Staff staff = session.get(Staff.class, id);
            session.delete(staff);
            tx.commit();
        }
    }
}
