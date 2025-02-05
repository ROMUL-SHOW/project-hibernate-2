package org.movie.data.cache;

import org.movie.data.db.dao.CustomerDAO;
import org.movie.data.entity.Customer;

import java.util.List;

public class CustomerManager {
    private CustomerDAO customerDAO;

    public CustomerManager(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    public Customer findById(Short id) {
        return customerDAO.findById(id);
    }

    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    public void delete(Short id) {
        customerDAO.delete(id);
    }
}
