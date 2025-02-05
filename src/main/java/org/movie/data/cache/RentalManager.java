package org.movie.data.cache;

import org.movie.data.db.dao.RentalDAO;
import org.movie.data.entity.Rental;

import java.util.List;

public class RentalManager {
    private final RentalDAO rentalDAO;

    public RentalManager(RentalDAO rentalDAO) {
        this.rentalDAO = rentalDAO;
    }

    public List<Rental> findAll() {
        return rentalDAO.findAll();
    }

    public Rental findById(Integer id) {
        return rentalDAO.findById(id);
    }

    public void save(Rental rental) {
        rentalDAO.save(rental);
    }

    public void update(Rental rental) {
        rentalDAO.update(rental);
    }

    public void delete(Integer id) {
        rentalDAO.delete(id);
    }
}
