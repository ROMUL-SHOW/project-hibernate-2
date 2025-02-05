package org.movie.domain.repository;

import org.movie.data.cache.CustomerCache;
import org.movie.data.entity.Customer;

import java.util.List;

public class CustomerRepositoryDBImpl implements CustomerRepository {
    private final CustomerCache customerCache;

    public CustomerRepositoryDBImpl(CustomerCache customerCache) {
        this.customerCache = customerCache;
    }

    @Override
    public List<Customer> findAll() {
        return customerCache.findAll();
    }

    @Override
    public Customer findById(Short id) {
        return customerCache.findById(id);
    }

    @Override
    public void save(Customer actor) {
        customerCache.save(actor);
    }

    @Override
    public void update(Customer actor) {
        customerCache.update(actor);
    }

    @Override
    public void delete(Short id) {
        customerCache.delete(id);
    }
}
