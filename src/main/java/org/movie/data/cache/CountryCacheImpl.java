package org.movie.data.cache;

import org.movie.data.entity.Country;

import java.util.List;

public class CountryCacheImpl implements CountryCache {
    private final CountryManager countryManager;

    public CountryCacheImpl(CountryManager countryManager) {
        this.countryManager = countryManager;
    }

    @Override
    public List<Country> findAll() {
        return countryManager.findAll();
    }

    @Override
    public Country findById(Short id) {
        return countryManager.findById(id);
    }

    @Override
    public void save(Country country) {
        countryManager.save(country);
    }

    @Override
    public void update(Country country) {
        countryManager.update(country);
    }

    @Override
    public void delete(Short id) {
        countryManager.delete(id);
    }
}
