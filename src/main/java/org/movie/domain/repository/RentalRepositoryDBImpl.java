package org.movie.domain.repository;

import org.movie.data.cache.RentalCache;
import org.movie.data.entity.Rental;

import java.util.List;

public class RentalRepositoryDBImpl implements RentalRepository {
    private final RentalCache rentalCache;

    public RentalRepositoryDBImpl(RentalCache rentalCache) {
        this.rentalCache = rentalCache;
    }

    @Override
    public List<Rental> findAll() {
        return rentalCache.findAll();
    }

    @Override
    public Rental findById(Integer id) {
        return rentalCache.findById(id);
    }

    @Override
    public void save(Rental rental) {
        rentalCache.save(rental);
    }

    @Override
    public void update(Rental rental) {
        rentalCache.update(rental);
    }

    @Override
    public void delete(Integer id) {
        rentalCache.delete(id);
    }
}
