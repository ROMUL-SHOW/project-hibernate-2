package org.movie.domain.interactor;

import org.movie.data.entity.Rental;
import org.movie.domain.repository.RentalRepository;

import java.util.List;

public class RentalInteractor {
    private final RentalRepository rentalRepository;

    public RentalInteractor(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    public Rental findById(Integer id) {
        return rentalRepository.findById(id);
    }

    public void save(Rental rental) {
        rentalRepository.save(rental);
    }

    public void update(Rental rental) {
        rentalRepository.update(rental);
    }

    public void delete(Integer id) {
        rentalRepository.delete(id);
    }
}
