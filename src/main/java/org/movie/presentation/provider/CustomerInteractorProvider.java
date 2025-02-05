package org.movie.presentation.provider;

import org.movie.domain.interactor.CustomerInteractor;

public class CustomerInteractorProvider implements Provider<CustomerInteractor> {

    @Override
    public CustomerInteractor provide() {
        CustomerRepositoryProvider customerRepositoryProvider = new CustomerRepositoryProvider();
        CustomerInteractor customerInteractor = new CustomerInteractor(customerRepositoryProvider.provide());
        return customerInteractor;
    }
}
