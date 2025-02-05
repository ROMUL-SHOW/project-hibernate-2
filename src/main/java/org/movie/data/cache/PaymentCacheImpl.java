package org.movie.data.cache;


import org.movie.data.entity.Payment;

import java.util.List;

public class PaymentCacheImpl implements PaymentCache {
    private final PaymentManager paymentManager;
    public PaymentCacheImpl(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    @Override
    public List<Payment> findAll() {
        return paymentManager.findAll();
    }

    @Override
    public Payment findById(Short id) {
        return paymentManager.findById(id);
    }

    @Override
    public void save(Payment payment) {
        paymentManager.save(payment);
    }

    @Override
    public void update(Payment payment) {
        paymentManager.update(payment);
    }

    @Override
    public void delete(Short id) {
        paymentManager.delete(id);
    }
}
