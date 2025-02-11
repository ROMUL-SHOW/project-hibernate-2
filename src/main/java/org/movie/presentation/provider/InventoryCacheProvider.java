package org.movie.presentation.provider;

import org.movie.data.cache.InventoryCache;
import org.movie.data.cache.InventoryCacheImpl;
import org.movie.data.cache.InventoryManager;
import org.movie.data.db.dao.InventoryDAO;

public class InventoryCacheProvider implements Provider<InventoryCache> {
    @Override
    public InventoryCache provide() {
        InventoryManager inventoryManager = new InventoryManager(new InventoryDAO());
        InventoryCache inventoryCache = new InventoryCacheImpl(inventoryManager);
        return inventoryCache;
    }
}
