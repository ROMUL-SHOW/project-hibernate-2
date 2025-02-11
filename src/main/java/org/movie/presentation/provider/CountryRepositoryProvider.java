package org.movie.presentation.provider;

import org.movie.domain.repository.CountryRepository;
import org.movie.domain.repository.CountryRepositoryDBImpl;

public class CountryRepositoryProvider implements Provider<CountryRepository> {

    @Override
    public CountryRepository provide() {
        CountryCacheProvider countryCacheProvider = new CountryCacheProvider();
        CountryRepository countryRepository = new CountryRepositoryDBImpl(countryCacheProvider.provide());
        return countryRepository;
    }
}
