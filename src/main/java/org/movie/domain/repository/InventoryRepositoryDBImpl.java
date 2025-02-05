package org.movie.domain.repository;

import org.movie.data.cache.InventoryCache;
import org.movie.data.entity.Inventory;

import java.util.List;

public class InventoryRepositoryDBImpl implements InventoryRepository {
    private final InventoryCache inventoryCache;

    public InventoryRepositoryDBImpl(InventoryCache inventoryCache) {
        this.inventoryCache = inventoryCache;
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryCache.findAll();
    }

    @Override
    public Inventory findById(Integer id) {
        return inventoryCache.findById(id);
    }

    @Override
    public void save(Inventory inventory) {
        inventoryCache.save(inventory);
    }

    @Override
    public void update(Inventory inventory) {
        inventoryCache.update(inventory);
    }

    @Override
    public void delete(Integer id) {
        inventoryCache.delete(id);
    }
}
