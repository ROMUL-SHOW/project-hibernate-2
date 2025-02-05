package org.movie.domain.interactor;

import org.movie.data.entity.Payment;
import org.movie.domain.repository.PaymentRepository;

import java.util.List;

public class PaymentInteractor {
    private final PaymentRepository paymentRepository;

    public PaymentInteractor(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment findById(Short id) {
        return paymentRepository.findById(id);
    }

    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

    public void update(Payment payment) {
        paymentRepository.update(payment);
    }

    public void delete(Short id) {
        paymentRepository.delete(id);
    }
}
