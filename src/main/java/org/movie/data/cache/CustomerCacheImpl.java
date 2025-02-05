package org.movie.data.cache;

import org.movie.data.entity.Customer;

import java.util.List;

public class CustomerCacheImpl implements CustomerCache {
    private final CustomerManager customerManager;

    public CustomerCacheImpl(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @Override
    public List<Customer> findAll() {
        return customerManager.findAll();
    }

    @Override
    public Customer findById(Short id) {
        return customerManager.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerManager.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerManager.update(customer);
    }

    @Override
    public void delete(Short id) {
        customerManager.delete(id);
    }
}
