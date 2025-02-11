package org.movie.presentation.provider;

import org.movie.data.cache.AddressCache;
import org.movie.data.cache.AddressCacheImpl;
import org.movie.data.cache.AddressManager;
import org.movie.data.db.dao.AddressDAO;

public class AddressCacheProvider implements Provider<AddressCache> {
    @Override
    public AddressCache provide() {
        AddressManager addressManager = new AddressManager(new AddressDAO());
        AddressCache addressCache = new AddressCacheImpl(addressManager);
        return addressCache;
    }
}
