package org.movie.presentation.provider;

import org.movie.domain.interactor.StaffInteractor;

public class StaffInteractorProvider implements Provider<StaffInteractor> {

    @Override
    public StaffInteractor provide() {
        StaffRepositoryProvider staffRepositoryProvider = new StaffRepositoryProvider();
        StaffInteractor staffInteractor = new StaffInteractor(staffRepositoryProvider.provide());
        return staffInteractor;
    }
}
