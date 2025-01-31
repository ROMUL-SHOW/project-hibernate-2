package org.movie.presentation.provider;

import org.movie.domain.repository.FilmRepository;
import org.movie.domain.repository.FilmRepositoryDBImpl;

public class FilmRepositoryProvider implements Provider<FilmRepository> {
    @Override
    public FilmRepository provide() {
        FilmCacheProvider filmCacheProvider = new FilmCacheProvider();
        FilmRepository filmRepository = new FilmRepositoryDBImpl(filmCacheProvider.provide());
        return filmRepository;
    }
}