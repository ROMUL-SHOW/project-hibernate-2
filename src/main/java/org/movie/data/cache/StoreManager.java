package org.movie.data.cache;

import org.movie.data.db.dao.StoreDAO;
import org.movie.data.entity.Store;

import java.util.List;

public class StoreManager {
    private final StoreDAO storeDAO;

    public StoreManager(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    public List<Store> findAll() {
        return storeDAO.findAll();
    }

    public Store findById(Byte id) {
        return storeDAO.findById(id);
    }

    public void save(Store store) {
        storeDAO.save(store);
    }

    public void update(Store store) {
        storeDAO.update(store);
    }

    public void delete(Byte id) {
        storeDAO.delete(id);
    }
}
