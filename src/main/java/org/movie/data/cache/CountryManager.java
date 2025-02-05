package org.movie.data.cache;

import org.movie.data.db.dao.CountryDAO;
import org.movie.data.entity.Country;

import java.util.List;

public class CountryManager {
    private final CountryDAO countryDAO;

    public CountryManager(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    public List<Country> findAll() {
        return countryDAO.findAll();
    }

    public Country findById(Short id) {
        return countryDAO.findById(id);
    }

    public void save(Country country) {
        countryDAO.save(country);
    }

    public void update(Country country) {
        countryDAO.update(country);
    }

    public void delete(Short id) {
        countryDAO.delete(id);
    }
}
