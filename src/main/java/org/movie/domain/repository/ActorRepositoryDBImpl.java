package org.movie.domain.repository;

import org.movie.data.cache.ActorCache;
import org.movie.data.entity.Actor;

import java.util.List;

public class ActorRepositoryDBImpl implements ActorRepository {
    private final ActorCache actorCache;

    public ActorRepositoryDBImpl(ActorCache actorCache) {
        this.actorCache = actorCache;
    }

    @Override
    public List<Actor> findAll() {
        return actorCache.findAll();
    }

    @Override
    public Actor findById(Short id) {
        return actorCache.findById(id);
    }

    @Override
    public Actor findByFullName(String firstName, String lastName) {
        return actorCache.findByFullName(firstName, lastName);
    }

    @Override
    public void save(Actor actor) {
        actorCache.save(actor);
    }

    @Override
    public void update(Actor actor) {
        actorCache.update(actor);
    }

    @Override
    public void delete(Short id) {
        actorCache.delete(id);
    }
}