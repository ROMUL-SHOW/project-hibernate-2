package org.movie.domain.repository;

import org.movie.data.entity.Rental;

import java.util.List;

public interface RentalRepository {
    List<Rental> findAll();
    Rental findById(Integer id);
    void save(Rental rental);
    void update(Rental rental);
    void delete(Integer id);
}
