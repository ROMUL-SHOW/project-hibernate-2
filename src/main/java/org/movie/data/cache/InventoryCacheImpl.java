package org.movie.data.cache;

import org.movie.data.entity.Inventory;

import java.util.List;

public class InventoryCacheImpl implements InventoryCache {
    private final InventoryManager inventoryManager;

    public InventoryCacheImpl(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryManager.findAll();
    }

    @Override
    public Inventory findById(Integer id) {
        return inventoryManager.findById(id);
    }

    @Override
    public void save(Inventory inventory) {
        inventoryManager.save(inventory);
    }

    @Override
    public void update(Inventory inventory) {
        inventoryManager.update(inventory);
    }

    @Override
    public void delete(Integer id) {
        inventoryManager.delete(id);
    }
}
