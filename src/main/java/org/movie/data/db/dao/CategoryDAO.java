package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.Category;

import java.util.List;

public class CategoryDAO {

    public List<Category> findAll() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Category> query = session.createQuery("from Category", Category.class);
            return query.list();
        }
    }
    public Category findById(Byte id) {
        try(Session session = HibernateUtil.getSession()) {
            String hql = "FROM Category WHERE id = :id";
            Query<Category> query = session.createQuery(hql, Category.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }
    public void save(Category category) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(category);
            tx.commit();
        }
    }
    public void update(Category category) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(category);
            tx.commit();
        }
    }
    public void delete(Byte id) {
        try(Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Category category = session.get(Category.class, id);
            session.delete(category);
            tx.commit();
        }
    }
}
