package org.movie.data.cache;



import org.movie.data.entity.Customer;

import java.util.List;

public interface CustomerCache {
    List<Customer> findAll();
    Customer findById(Short id);
    void save(Customer customer);
    void update(Customer customer);
    void delete(Short id);
}
