package org.movie.data.cache;

import org.movie.data.entity.Address;

import java.util.List;

public class AddressCacheImpl implements AddressCache {
    private final AddressManager addressManager;

    public AddressCacheImpl(AddressManager addressManager) {
        this.addressManager = addressManager;
    }

    @Override
    public List<Address> findAll() {
        return addressManager.findAll();
    }

    @Override
    public Address findById(Short id) {
        return addressManager.findById(id);
    }

    @Override
    public void save(Address address) {
        addressManager.save(address);
    }

    @Override
    public void update(Address address) {
        addressManager.update(address);
    }

    @Override
    public void delete(Short id) {
        addressManager.delete(id);
    }
}
