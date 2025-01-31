package org.movie.presentation.provider;

import org.movie.data.cache.ActorCache;
import org.movie.data.cache.ActorCacheImpl;
import org.movie.data.cache.ActorManager;
import org.movie.data.db.dao.ActorDAO;

public class ActorCacheProvider implements Provider<ActorCache> {
    @Override
    public ActorCache provide() {
        ActorManager actorManager = new ActorManager(new ActorDAO());
        ActorCache actorCache = new ActorCacheImpl(actorManager);
        return actorCache;
    }
}
