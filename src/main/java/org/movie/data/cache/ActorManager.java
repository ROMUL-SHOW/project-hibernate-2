package org.movie.data.cache;

import org.movie.data.db.dao.ActorDAO;
import org.movie.data.entity.Actor;
import java.util.List;

public class ActorManager {
    private final ActorDAO actorDAO;

    public ActorManager(ActorDAO actorDAO) {
        this.actorDAO = actorDAO;
    }
    public List<Actor> findAll() {
        return actorDAO.findAll();
    }

    public Actor findById(Short id) {
        return actorDAO.findById(id);
    }

    public void save(Actor actor) {
        actorDAO.save(actor);
    }

    public void update(Actor actor) {
        actorDAO.update(actor);
    }

    public void delete(Short id) {
        actorDAO.delete(id);
    }
}
