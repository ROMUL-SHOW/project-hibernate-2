package org.movie.domain.interactor;

import org.movie.data.entity.Country;
import org.movie.domain.repository.CountryRepository;

import java.util.List;

public class CountryInteractor {
    private final CountryRepository countryRepository;

    public CountryInteractor(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findById(Short id) {
        return countryRepository.findById(id);
    }

    public void save(Country country) {
        countryRepository.save(country);
    }

    public void update(Country country) {
        countryRepository.update(country);
    }

    public void delete(Short id) {
        countryRepository.delete(id);
    }
}
