package org.movie.data.cache;

import org.movie.data.db.dao.AddressDAO;
import org.movie.data.entity.Address;

import java.util.List;

public class AddressManager {
    private final AddressDAO addressDAO;

    public AddressManager(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    public List<Address> findAll() {
        return addressDAO.findAll();
    }

    public Address findById(Short id) {
        return addressDAO.findById(id);
    }

    public void save(Address address) {
        addressDAO.save(address);
    }

    public void update(Address address) {
        addressDAO.update(address);
    }

    public void delete(Short id) {
        addressDAO.delete(id);
    }
}