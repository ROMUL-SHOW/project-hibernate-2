package org.movie.data.cache;

import org.movie.data.entity.Film;

import java.util.List;

public class FilmCacheImpl implements FilmCache {
    private final FilmManager filmManager;

    public FilmCacheImpl(FilmManager filmManager) {
        this.filmManager = filmManager;
    }

    @Override
    public List<Film> findAll() {
        return filmManager.findAll();
    }

    @Override
    public Film findById(Short id) {
        return filmManager.findById(id);
    }

    @Override
    public void save(Film film) {
        filmManager.save(film);
    }

    @Override
    public void update(Film film) {
        filmManager.update(film);
    }

    @Override
    public void delete(Short id) {
        filmManager.delete(id);
    }
}