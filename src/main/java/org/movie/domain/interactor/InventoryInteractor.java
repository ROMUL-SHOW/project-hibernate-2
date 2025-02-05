package org.movie.domain.interactor;

import org.movie.data.entity.Inventory;
import org.movie.domain.repository.InventoryRepository;

import java.util.List;

public class InventoryInteractor {
    private final InventoryRepository inventoryRepository;

    public InventoryInteractor(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    public Inventory findById(Integer id) {
        return inventoryRepository.findById(id);
    }

    public void save(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    public void update(Inventory inventory) {
        inventoryRepository.update(inventory);
    }

    public void delete(Integer id) {
        inventoryRepository.delete(id);
    }
}
