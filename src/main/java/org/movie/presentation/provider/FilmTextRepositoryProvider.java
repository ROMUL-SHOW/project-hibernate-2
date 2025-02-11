package org.movie.presentation.provider;

import org.movie.domain.repository.FilmTextRepository;
import org.movie.domain.repository.FilmTextRepositoryDBImpl;

public class FilmTextRepositoryProvider implements Provider<FilmTextRepository> {
    @Override
    public FilmTextRepository provide() {
        FilmTextCacheProvider filmTextCacheProvider = new FilmTextCacheProvider();
        FilmTextRepository filmTextRepository = new FilmTextRepositoryDBImpl(filmTextCacheProvider.provide());
        return filmTextRepository;
    }
}