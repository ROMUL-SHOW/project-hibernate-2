package org.movie.presentation.provider;

import org.movie.data.cache.CustomerCache;
import org.movie.data.cache.CustomerCacheImpl;
import org.movie.data.cache.CustomerManager;
import org.movie.data.db.dao.CustomerDAO;

public class CustomerCacheProvider implements Provider<CustomerCache> {

    @Override
    public CustomerCache provide() {
        CustomerManager customerManager = new CustomerManager(new CustomerDAO());
        CustomerCache customerCache = new CustomerCacheImpl(customerManager);
        return customerCache;
    }
}
