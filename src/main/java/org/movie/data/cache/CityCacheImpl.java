package org.movie.data.cache;

import org.movie.data.entity.City;

import java.util.List;

public class CityCacheImpl implements CityCache {
    private final CityManager cityManager;

    public CityCacheImpl(CityManager cityManager) {
        this.cityManager = cityManager;
    }

    @Override
    public List<City> findAll() {
        return cityManager.findAll();
    }

    @Override
    public City findById(Short id) {
        return cityManager.findById(id);
    }

    @Override
    public void save(City city) {
        cityManager.save(city);
    }

    @Override
    public void update(City city) {
        cityManager.update(city);
    }

    @Override
    public void delete(Short id) {
        cityManager.delete(id);
    }
}
