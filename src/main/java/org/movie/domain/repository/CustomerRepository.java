package org.movie.domain.repository;


import org.movie.data.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(Short id);

    void save(Customer actor);

    void update(Customer actor);

    void delete(Short id);
}
