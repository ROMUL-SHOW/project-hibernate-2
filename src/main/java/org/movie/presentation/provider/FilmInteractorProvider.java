package org.movie.presentation.provider;

import org.movie.domain.interactor.FilmInteractor;


public class FilmInteractorProvider implements Provider<FilmInteractor> {
    @Override
    public FilmInteractor provide() {
        FilmRepositoryProvider filmRepositoryProvider = new FilmRepositoryProvider();
        FilmInteractor filmInteractor = new FilmInteractor(filmRepositoryProvider.provide());
        return filmInteractor;
    }
}
