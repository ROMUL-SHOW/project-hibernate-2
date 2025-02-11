package org.movie.presentation.provider;

import org.movie.domain.interactor.FilmTextInteractor;


public class FilmTextInteractorProvider implements Provider<FilmTextInteractor> {
    @Override
    public FilmTextInteractor provide() {
        FilmTextRepositoryProvider filmTextRepositoryProvider = new FilmTextRepositoryProvider();
        FilmTextInteractor filmTextInteractor = new FilmTextInteractor(filmTextRepositoryProvider.provide());
        return filmTextInteractor;
    }
}
