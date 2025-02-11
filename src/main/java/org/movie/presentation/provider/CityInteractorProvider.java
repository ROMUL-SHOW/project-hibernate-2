package org.movie.presentation.provider;

import org.movie.domain.interactor.CityInteractor;

public class CityInteractorProvider implements Provider<CityInteractor> {

    @Override
    public CityInteractor provide() {
        CityRepositoryProvider cityRepositoryProvider = new CityRepositoryProvider();
        CityInteractor cityInteractor = new CityInteractor(cityRepositoryProvider.provide());
        return cityInteractor;
    }
}
