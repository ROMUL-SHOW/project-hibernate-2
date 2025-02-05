package org.movie.domain.repository;

import org.movie.data.cache.FilmCache;
import org.movie.data.entity.Film;

import java.util.List;

public class FilmRepositoryDBImpl implements FilmRepository {
    private FilmCache filmCache;

    public FilmRepositoryDBImpl(FilmCache filmCache) {
        this.filmCache = filmCache;
    }

    @Override
    public List<Film> findAll() {
        return filmCache.findAll();
    }

    @Override
    public Film findById(Short id) {
        return filmCache.findById(id);
    }

    @Override
    public void save(Film film) {
        filmCache.save(film);
    }

    @Override
    public void delete(Short id) {
        filmCache.delete(id);
    }

    @Override
    public void update(Film film) {
        filmCache.update(film);
    }
}
