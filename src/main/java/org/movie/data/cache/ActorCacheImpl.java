package org.movie.data.cache;

import org.movie.data.entity.Actor;

import java.util.List;

public class ActorCacheImpl implements ActorCache {
    private final ActorManager actorManager;

    public ActorCacheImpl(ActorManager actorManager) {
        this.actorManager = actorManager;
    }

    @Override
    public List<Actor> findAll() {
        return actorManager.findAll();
    }

    @Override
    public Actor findById(Short id) {
        return actorManager.findById(id);
    }

    @Override
    public void save(Actor actor) {
        actorManager.save(actor);
    }

    @Override
    public void update(Actor actor) {
        actorManager.update(actor);
    }

    @Override
    public void delete(Short id) {
        actorManager.delete(id);
    }
}
