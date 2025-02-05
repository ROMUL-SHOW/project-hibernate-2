package org.movie.presentation.provider;

import org.movie.domain.repository.CustomerRepository;
import org.movie.domain.repository.CustomerRepositoryDBImpl;

public class CustomerRepositoryProvider implements Provider<CustomerRepository> {

    @Override
    public CustomerRepository provide() {
        CustomerCacheProvider customerCacheProvider = new CustomerCacheProvider();
        CustomerRepository customerRepository = new CustomerRepositoryDBImpl(customerCacheProvider.provide());
        return customerRepository;
    }
}
