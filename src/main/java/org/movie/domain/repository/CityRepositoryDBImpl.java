package org.movie.domain.repository;

import org.movie.data.cache.CityCache;
import org.movie.data.entity.City;

import java.util.List;

public class CityRepositoryDBImpl implements CityRepository {
    private final CityCache cityCache;

    public CityRepositoryDBImpl(CityCache cityCache) {
        this.cityCache = cityCache;
    }

    @Override
    public List<City> findAll() {
        return cityCache.findAll();
    }

    @Override
    public City findById(Short id) {
        return cityCache.findById(id);
    }

    @Override
    public void save(City city) {
        cityCache.save(city);
    }

    @Override
    public void update(City city) {
        cityCache.update(city);
    }

    @Override
    public void delete(Short id) {
        cityCache.delete(id);
    }
}
