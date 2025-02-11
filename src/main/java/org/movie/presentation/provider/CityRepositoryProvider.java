package org.movie.presentation.provider;

import org.movie.domain.repository.CityRepository;
import org.movie.domain.repository.CityRepositoryDBImpl;

public class CityRepositoryProvider implements Provider<CityRepository> {

    @Override
    public CityRepository provide() {
        CityCacheProvider cityCacheProvider = new CityCacheProvider();
        CityRepository cityRepository = new CityRepositoryDBImpl(cityCacheProvider.provide());
        return cityRepository;
    }
}
