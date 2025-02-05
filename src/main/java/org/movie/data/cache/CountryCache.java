package org.movie.data.cache;

import org.movie.data.entity.Address;
import org.movie.data.entity.Country;

import java.util.List;

public interface CountryCache {
    List<Country> findAll();
    Country findById(Short id);
    void save(Country country);
    void update(Country country);
    void delete(Short id);
}
