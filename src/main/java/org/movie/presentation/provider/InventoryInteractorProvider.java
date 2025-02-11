package org.movie.presentation.provider;

import org.movie.domain.interactor.InventoryInteractor;

public class InventoryInteractorProvider implements Provider<InventoryInteractor> {

    @Override
    public InventoryInteractor provide() {
        InventoryRepositoryProvider inventoryRepositoryProvider = new InventoryRepositoryProvider();
        InventoryInteractor inventoryInteractor = new InventoryInteractor(inventoryRepositoryProvider.provide());
        return inventoryInteractor;
    }
}
