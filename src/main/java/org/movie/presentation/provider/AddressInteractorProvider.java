package org.movie.presentation.provider;

import org.movie.domain.interactor.AddressInteractor;

public class AddressInteractorProvider implements Provider<AddressInteractor> {

    @Override
    public AddressInteractor provide() {
        AddressRepositoryProvider addressRepositoryProvider = new AddressRepositoryProvider();
        AddressInteractor addressInteractor = new AddressInteractor(addressRepositoryProvider.provide());
        return addressInteractor;
    }
}
