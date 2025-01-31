package org.movie.presentation.provider;

import org.movie.domain.repository.ActorRepository;
import org.movie.domain.repository.ActorRepositoryDBImpl;

public class ActorRepositoryProvider implements Provider<ActorRepository> {
    @Override
    public ActorRepository provide() {
        ActorCacheProvider actorCacheProvider = new ActorCacheProvider();
        ActorRepository actorRepository = new ActorRepositoryDBImpl(actorCacheProvider.provide());
        return actorRepository;
    }
}
