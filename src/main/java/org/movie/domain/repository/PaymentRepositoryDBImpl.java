package org.movie.domain.repository;

import org.movie.data.cache.PaymentCache;
import org.movie.data.entity.Payment;

import java.util.List;

public class PaymentRepositoryDBImpl implements PaymentRepository {
    private final PaymentCache paymentCache;

    public PaymentRepositoryDBImpl(PaymentCache paymentCache) {
        this.paymentCache = paymentCache;
    }

    @Override
    public List<Payment> findAll() {
        return paymentCache.findAll();
    }

    @Override
    public Payment findById(Short id) {
        return paymentCache.findById(id);
    }

    @Override
    public void save(Payment payment) {
        paymentCache.save(payment);
    }

    @Override
    public void update(Payment payment) {
        paymentCache.update(payment);
    }

    @Override
    public void delete(Short id) {
        paymentCache.delete(id);
    }
}