package org.movie.presentation.provider;

import org.movie.domain.interactor.CountryInteractor;

public class CountryInteractorProvider implements Provider<CountryInteractor> {

    @Override
    public CountryInteractor provide() {
        CountryRepositoryProvider countryRepositoryProvider = new CountryRepositoryProvider();
        CountryInteractor countryInteractor = new CountryInteractor(countryRepositoryProvider.provide());
        return countryInteractor;
    }
}
