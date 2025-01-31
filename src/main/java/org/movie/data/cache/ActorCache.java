package org.movie.data.cache;

import org.movie.data.entity.Actor;
import org.movie.data.entity.Film;

import java.util.List;

public interface ActorCache {
    List<Actor> findAll();
    Actor findById(Short id);
    void save(Actor actor);
    void update(Actor actor);
    void delete(Short id);
}
