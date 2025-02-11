package org.movie.presentation.provider;

import org.movie.data.cache.FilmTextCache;
import org.movie.data.cache.FilmTextCacheImpl;
import org.movie.data.cache.FilmTextManager;
import org.movie.data.db.dao.FilmTextDAO;

public class FilmTextCacheProvider implements Provider<FilmTextCache> {

    @Override
    public FilmTextCache provide() {
        FilmTextManager filmTextManager = new FilmTextManager(new FilmTextDAO());
        FilmTextCache filmTextCache = new FilmTextCacheImpl(filmTextManager);
        return filmTextCache;
    }
}
