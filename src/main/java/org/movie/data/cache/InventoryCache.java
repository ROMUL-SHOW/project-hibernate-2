package org.movie.data.cache;

import org.movie.data.entity.Inventory;

import java.util.List;

public interface InventoryCache {
    List<Inventory> findAll();
    Inventory findById(Integer id);
    void save(Inventory inventory);
    void update(Inventory inventory);
    void delete(Integer id);
}
