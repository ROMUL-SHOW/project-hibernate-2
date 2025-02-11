package org.movie.presentation.provider;

import org.movie.domain.repository.PaymentRepository;
import org.movie.domain.repository.PaymentRepositoryDBImpl;

public class PaymentRepositoryProvider implements Provider<PaymentRepository> {
    @Override
    public PaymentRepository provide() {
        PaymentCacheProvider paymentCacheProvider = new PaymentCacheProvider();
        PaymentRepository paymentRepository = new PaymentRepositoryDBImpl(paymentCacheProvider.provide());
        return paymentRepository;
    }
}
