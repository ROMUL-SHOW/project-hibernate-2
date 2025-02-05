package org.movie.domain.repository;

import org.movie.data.entity.Payment;

import java.util.List;

public interface PaymentRepository {
    List<Payment> findAll();
    Payment findById(Short id);
    void save(Payment payment);
    void update(Payment payment);
    void delete(Short id);
}
