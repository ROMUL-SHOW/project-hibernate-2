package org.movie.data.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.movie.data.db.util.HibernateUtil;
import org.movie.data.entity.Actor;

import java.util.List;

public class ActorDAO {

    public List<Actor> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Actor> query = session.createQuery("from Actor", Actor.class);
            return query.list();
        }
    }

    public Actor findById(Short id) {
        try (Session session = HibernateUtil.getSession()) {
            String hql = "FROM Actor WHERE id = :id";
            Query<Actor> query = session.createQuery(hql, Actor.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }

    public Actor findByFullName(String firstName, String lastName) {
        try (Session session = HibernateUtil.getSession()) {
            String hql = "FROM Actor WHERE UPPER(firstName) = :firstName AND UPPER(lastName) = :lastName";
            Query<Actor> query = session.createQuery(hql, Actor.class);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            query.setMaxResults(1);
            return query.uniqueResult();
        }
    }

        public void save (Actor actor){
            try (Session session = HibernateUtil.getSession()) {
                Transaction tx = session.beginTransaction();
                session.save(actor);
                tx.commit();
            }
        }

        public void update (Actor actor){
            try (Session session = HibernateUtil.getSession()) {
                Transaction tx = session.beginTransaction();
                session.update(actor);
                tx.commit();
            }
        }

        public void delete (Short id){
            try (Session session = HibernateUtil.getSession()) {
                Transaction tx = session.beginTransaction();
                Actor actor = session.get(Actor.class, id);
                session.delete(actor);
                tx.commit();
            }
        }
    }
