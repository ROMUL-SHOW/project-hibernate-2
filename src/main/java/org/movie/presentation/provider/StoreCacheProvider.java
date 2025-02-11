package org.movie.presentation.provider;

import org.movie.data.cache.StoreCache;
import org.movie.data.cache.StoreCacheImpl;
import org.movie.data.cache.StoreManager;
import org.movie.data.db.dao.StoreDAO;

public class StoreCacheProvider implements Provider<StoreCache> {
    @Override
    public StoreCache provide() {
        StoreManager storeManager = new StoreManager(new StoreDAO());
        StoreCache storeCache = new StoreCacheImpl(storeManager);
        return storeCache;
    }
}
