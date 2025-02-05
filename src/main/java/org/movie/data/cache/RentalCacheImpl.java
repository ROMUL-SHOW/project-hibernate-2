package org.movie.data.cache;

import org.movie.data.entity.Rental;

import java.util.List;

public class RentalCacheImpl implements RentalCache {
    private final RentalManager rentalManager;

    public RentalCacheImpl(RentalManager rentalManager) {
        this.rentalManager = rentalManager;
    }

    @Override
    public List<Rental> findAll() {
        return rentalManager.findAll();
    }

    @Override
    public Rental findById(Integer id) {
        return rentalManager.findById(id);
    }

    @Override
    public void save(Rental rental) {
        rentalManager.save(rental);
    }

    @Override
    public void update(Rental rental) {
        rentalManager.update(rental);
    }

    @Override
    public void delete(Integer id) {
        rentalManager.delete(id);
    }
}
