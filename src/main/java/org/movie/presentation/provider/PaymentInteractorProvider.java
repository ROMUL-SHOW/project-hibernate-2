package org.movie.presentation.provider;

import org.movie.domain.interactor.PaymentInteractor;

public class PaymentInteractorProvider implements Provider<PaymentInteractor> {

    @Override
    public PaymentInteractor provide() {
        PaymentRepositoryProvider paymentRepositoryProvider = new PaymentRepositoryProvider();
        PaymentInteractor paymentInteractor = new PaymentInteractor(paymentRepositoryProvider.provide());
        return paymentInteractor;
    }
}
