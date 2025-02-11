package org.movie.presentation.provider;

import org.movie.domain.interactor.RentalInteractor;

public class RentalInteractorProvider implements Provider<RentalInteractor> {

    @Override
    public RentalInteractor provide() {
        RentalRepositoryProvider rentalRepositoryProvider = new RentalRepositoryProvider();
        RentalInteractor rentalInteractor = new RentalInteractor(rentalRepositoryProvider.provide());
        return rentalInteractor;
    }
}
