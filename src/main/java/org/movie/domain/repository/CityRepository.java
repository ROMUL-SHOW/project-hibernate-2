package org.movie.domain.repository;

import org.movie.data.entity.City;

import java.util.List;

public interface CityRepository {
    List<City> findAll();

    City findById(Short id);

    void save(City city);

    void update(City city);

    void delete(Short id);
}
