package org.movie.domain.interactor;

import org.movie.data.entity.Address;
import org.movie.domain.repository.AddressRepository;

import java.util.List;

public class AddressInteractor {
    private final AddressRepository addressRepository;

    public AddressInteractor(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Short id) {
        return addressRepository.findById(id);
    }

    public void save(Address address) {
        addressRepository.save(address);
    }

    public void update(Address address) {
        addressRepository.update(address);
    }

    public void delete(Short id) {
        addressRepository.delete(id);
    }
}
