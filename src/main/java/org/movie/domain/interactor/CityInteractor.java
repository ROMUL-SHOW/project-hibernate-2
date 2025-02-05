package org.movie.domain.interactor;

import org.movie.data.entity.City;
import org.movie.domain.repository.CityRepository;

import java.util.List;

public class CityInteractor {
    private final CityRepository cityRepository;

    public CityInteractor(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City findById(Short id) {
        return cityRepository.findById(id);
    }

    public void save(City city) {
        cityRepository.save(city);
    }

    public void update(City city) {
        cityRepository.update(city);
    }

    public void delete(Short id) {
        cityRepository.delete(id);
    }
}
