package org.movie.presentation.provider;

import org.movie.domain.interactor.StoreInteractor;

public class StoreInteractorProvider implements Provider<StoreInteractor> {

    @Override
    public StoreInteractor provide() {
        StoreRepositoryProvider storeRepositoryProvider = new StoreRepositoryProvider();
        StoreInteractor storeInteractor = new StoreInteractor(storeRepositoryProvider.provide());
        return storeInteractor;
    }
}
