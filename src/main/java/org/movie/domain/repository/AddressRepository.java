package org.movie.domain.repository;

import org.movie.data.entity.Address;

import java.util.List;

public interface AddressRepository {
    List<Address> findAll();

    Address findById(Short id);

    void save(Address address);

    void update(Address address);

    void delete(Short id);
}
