package org.movie.data.cache;

import org.movie.data.db.dao.CityDAO;
import org.movie.data.entity.City;

import java.util.List;

public class CityManager {
    private final CityDAO cityDAO;

    public CityManager(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    public List<City> findAll() {
        return cityDAO.findAll();
    }

    public City findById(Short id) {
        return cityDAO.findById(id);
    }

    public void save(City city) {
        cityDAO.save(city);
    }

    public void update(City city) {
        cityDAO.update(city);
    }

    public void delete(Short id) {
        cityDAO.delete(id);
    }
}