package org.movie.data.cache;

import org.movie.data.entity.City;

import java.util.List;

public interface CityCache {
    List<City> findAll();
    City findById(Short id);
    void save(City city);
    void update(City city);
    void delete(Short id);
}
