package org.movie.presentation.provider;

import org.movie.domain.repository.InventoryRepository;
import org.movie.domain.repository.InventoryRepositoryDBImpl;

public class InventoryRepositoryProvider implements Provider<InventoryRepository> {
    @Override
    public InventoryRepository provide() {
        InventoryCacheProvider inventoryCacheProvider = new InventoryCacheProvider();
        InventoryRepository inventoryRepository = new InventoryRepositoryDBImpl(inventoryCacheProvider.provide());
        return inventoryRepository;
    }
}
