package org.movie.presentation.provider;

import org.movie.domain.repository.StoreRepository;
import org.movie.domain.repository.StoreRepositoryDBImpl;

public class StoreRepositoryProvider implements Provider<StoreRepository> {
    @Override
    public StoreRepository provide() {
        StoreCacheProvider storeCacheProvider = new StoreCacheProvider();
        StoreRepository storeRepository = new StoreRepositoryDBImpl(storeCacheProvider.provide());
        return storeRepository;
    }
}
