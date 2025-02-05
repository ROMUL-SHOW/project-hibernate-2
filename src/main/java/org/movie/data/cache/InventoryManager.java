package org.movie.data.cache;

import org.movie.data.db.dao.InventoryDAO;
import org.movie.data.entity.Inventory;

import java.util.List;

public class InventoryManager {
    private final InventoryDAO inventoryDAO;

    public InventoryManager(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    public List<Inventory> findAll() {
        return inventoryDAO.findAll();
    }

    public Inventory findById(Integer id) {
        return inventoryDAO.findById(id);
    }

    public void save(Inventory inventory) {
        inventoryDAO.save(inventory);
    }

    public void update(Inventory inventory) {
        inventoryDAO.update(inventory);
    }

    public void delete(Integer id) {
        inventoryDAO.delete(id);
    }
}