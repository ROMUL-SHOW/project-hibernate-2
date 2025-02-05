package org.movie.domain.repository;


import org.movie.data.entity.Inventory;

import java.util.List;

public interface InventoryRepository {
    List<Inventory> findAll();

    Inventory findById(Integer id);

    void save(Inventory inventory);

    void update(Inventory inventory);

    void delete(Integer id);
}
