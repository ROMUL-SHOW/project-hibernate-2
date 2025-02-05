package org.movie.domain.interactor;

import org.movie.data.entity.Customer;
import org.movie.domain.repository.CustomerRepository;

import java.util.List;

public class CustomerInteractor {
    private final CustomerRepository customerRepository;

    public CustomerInteractor(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Short id) {
        return customerRepository.findById(id);
    }

    public void save(Customer actor) {
        customerRepository.save(actor);
    }

    public void update(Customer actor) {
        customerRepository.update(actor);
    }

    public void delete(Short id) {
        customerRepository.delete(id);
    }
}
