package org.movie.domain.repository;

import org.movie.data.cache.CountryCache;
import org.movie.data.entity.Country;

import java.util.List;

public class CountryRepositoryDBImpl implements CountryRepository {
    private final CountryCache countryCache;

    public CountryRepositoryDBImpl(CountryCache countryCache) {
        this.countryCache = countryCache;
    }

    @Override
    public List<Country> findAll() {
        return countryCache.findAll();
    }

    @Override
    public Country findById(Short id) {
        return countryCache.findById(id);
    }

    @Override
    public void save(Country country) {
        countryCache.save(country);
    }

    @Override
    public void update(Country country) {
        countryCache.update(country);
    }

    @Override
    public void delete(Short id) {
        countryCache.delete(id);
    }
}
