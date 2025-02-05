package org.movie.domain.repository;

import org.movie.data.cache.AddressCache;
import org.movie.data.entity.Address;

import java.util.List;

public class AddressRepositoryDBImpl implements AddressRepository {
    private final AddressCache addressCache;

    public AddressRepositoryDBImpl(AddressCache addressCache) {
        this.addressCache = addressCache;
    }

    @Override
    public List<Address> findAll() {
        return addressCache.findAll();
    }

    @Override
    public Address findById(Short id) {
        return addressCache.findById(id);
    }

    @Override
    public void save(Address address) {
        addressCache.save(address);
    }

    @Override
    public void update(Address address) {
        addressCache.update(address);
    }

    @Override
    public void delete(Short id) {
        addressCache.delete(id);
    }
}
