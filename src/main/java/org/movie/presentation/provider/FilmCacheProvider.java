package org.movie.presentation.provider;

import org.movie.data.cache.FilmCache;
import org.movie.data.cache.FilmCacheImpl;
import org.movie.data.cache.FilmManager;
import org.movie.data.db.dao.FilmDAO;

public class FilmCacheProvider implements Provider<FilmCache> {

    @Override
    public FilmCache provide() {
        FilmManager filmManager = new FilmManager(new FilmDAO());
        FilmCache filmCache = new FilmCacheImpl(filmManager);
        return filmCache;
    }
}
