package org.movie.domain.repository;

import org.movie.data.entity.Actor;

import java.util.List;

public interface ActorRepository {
    List<Actor> findAll();

    Actor findById(Short id);
    Actor findByFullName(String firstName, String lastName);

    void save(Actor actor);

    void update(Actor actor);

    void delete(Short id);
}
