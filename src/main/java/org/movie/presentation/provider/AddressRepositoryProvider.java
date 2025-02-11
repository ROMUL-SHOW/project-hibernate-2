package org.movie.presentation.provider;

import org.movie.domain.repository.AddressRepository;
import org.movie.domain.repository.AddressRepositoryDBImpl;

public class AddressRepositoryProvider implements Provider<AddressRepository> {

    @Override
    public AddressRepository provide() {
        AddressCacheProvider addressCacheProvider = new AddressCacheProvider();
        AddressRepository addressRepository = new AddressRepositoryDBImpl(addressCacheProvider.provide());
        return addressRepository;
    }
}
