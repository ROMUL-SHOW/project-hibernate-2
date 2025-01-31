package org.movie.domain.interactor;

import org.movie.data.entity.Actor;
import org.movie.domain.repository.ActorRepository;
import java.util.List;

public class ActorInteractor {
    private ActorRepository actorRepository;

    public ActorInteractor(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }
    public Actor findById(Short id) {
        return actorRepository.findById(id);
    }
    public void save(Actor actor) {
        actorRepository.save(actor);
    }
    public void delete(Short id) {
        actorRepository.delete(id);
    }
    public void update(Actor actor) {
        actorRepository.update(actor);
    }
}
