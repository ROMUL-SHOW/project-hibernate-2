package org.movie.domain.repository;

import org.movie.data.cache.StoreCache;
import org.movie.data.entity.Store;

import java.util.List;

public class StoreRepositoryDBImpl implements StoreRepository {
    private final StoreCache storeCache;

    public StoreRepositoryDBImpl(StoreCache storeCache) {
        this.storeCache = storeCache;
    }

    @Override
    public List<Store> findAll() {
        return storeCache.findAll();
    }

    @Override
    public Store findById(Byte id) {
        return storeCache.findById(id);
    }

    @Override
    public void save(Store store) {
        storeCache.save(store);
    }

    @Override
    public void update(Store store) {
        storeCache.update(store);
    }

    @Override
    public void delete(Byte id) {
        storeCache.delete(id);
    }
}
