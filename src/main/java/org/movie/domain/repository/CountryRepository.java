package org.movie.domain.repository;

import org.movie.data.entity.Country;

import java.util.List;

public interface CountryRepository {
    List<Country> findAll();

    Country findById(Short id);

    void save(Country country);

    void update(Country country);

    void delete(Short id);
}
