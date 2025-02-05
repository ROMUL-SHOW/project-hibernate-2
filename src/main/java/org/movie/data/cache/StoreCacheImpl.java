package org.movie.data.cache;

import org.movie.data.entity.Store;

import java.util.List;

public class StoreCacheImpl implements StoreCache {
    private final StoreManager storeManager;

    public StoreCacheImpl(StoreManager storeManager) {
        this.storeManager = storeManager;
    }

    @Override
    public List<Store> findAll() {
        return storeManager.findAll();
    }

    @Override
    public Store findById(Byte id) {
        return storeManager.findById(id);
    }

    @Override
    public void save(Store store) {
        storeManager.save(store);
    }

    @Override
    public void update(Store store) {
        storeManager.update(store);
    }

    @Override
    public void delete(Byte id) {
        storeManager.delete(id);
    }
}
