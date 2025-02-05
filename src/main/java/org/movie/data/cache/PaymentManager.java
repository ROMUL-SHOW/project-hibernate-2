package org.movie.data.cache;

import org.movie.data.db.dao.PaymentDAO;
import org.movie.data.entity.Payment;

import java.util.List;

public class PaymentManager {
    private final PaymentDAO paymentDAO;

    public PaymentManager(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public List<Payment> findAll() {
        return paymentDAO.findAll();
    }

    public Payment findById(Short id) {
        return paymentDAO.findById(id);
    }

    public void save(Payment payment) {
        paymentDAO.save(payment);
    }

    public void update(Payment payment) {
        paymentDAO.update(payment);
    }

    public void delete(Short id) {
        paymentDAO.delete(id);
    }
}
