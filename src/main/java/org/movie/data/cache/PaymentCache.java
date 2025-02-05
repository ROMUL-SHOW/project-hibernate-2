package org.movie.data.cache;

import org.movie.data.entity.Payment;

import java.util.List;

public interface PaymentCache {
    List<Payment> findAll();
    Payment findById(Short id);
    void save(Payment payment);
    void update(Payment payment);
    void delete(Short id);
}
