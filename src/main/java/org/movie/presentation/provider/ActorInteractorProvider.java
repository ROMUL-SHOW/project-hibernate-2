package org.movie.presentation.provider;

import org.movie.domain.interactor.ActorInteractor;

public class ActorInteractorProvider implements Provider<ActorInteractor> {
    @Override
    public ActorInteractor provide() {
        ActorRepositoryProvider actorRepositoryProvider = new ActorRepositoryProvider();
        ActorInteractor actorInteractor = new ActorInteractor(actorRepositoryProvider.provide());
        return actorInteractor;
    }
}
