package org.movie.data.cache;

import org.movie.data.entity.Address;

import java.util.List;

public interface AddressCache {
    List<Address> findAll();
    Address findById(Short id);
    void save(Address address);
    void update(Address address);
    void delete(Short id);
}
