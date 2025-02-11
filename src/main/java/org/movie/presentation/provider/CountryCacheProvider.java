package org.movie.presentation.provider;

import org.movie.data.cache.CountryCache;
import org.movie.data.cache.CountryCacheImpl;
import org.movie.data.cache.CountryManager;
import org.movie.data.db.dao.CountryDAO;

public class CountryCacheProvider implements Provider<CountryCache> {
    @Override
    public CountryCache provide() {
        CountryManager countryManager = new CountryManager(new CountryDAO());
        CountryCache countryCache = new CountryCacheImpl(countryManager);
        return countryCache;
    }
}
