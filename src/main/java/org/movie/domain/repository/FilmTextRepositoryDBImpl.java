package org.movie.domain.repository;

import org.movie.data.cache.FilmTextCache;
import org.movie.data.entity.FilmText;

import java.util.List;

public class FilmTextRepositoryDBImpl implements FilmTextRepository {
    private final FilmTextCache filmTextCache;

    public FilmTextRepositoryDBImpl(FilmTextCache filmTextCache) {
        this.filmTextCache = filmTextCache;
    }

    @Override
    public List<FilmText> findAll() {
        return filmTextCache.findAll();
    }

    @Override
    public FilmText findById(Short id) {
        return filmTextCache.findById(id);
    }

    @Override
    public void save(FilmText filmText) {
        filmTextCache.save(filmText);
    }

    @Override
    public void update(FilmText filmText) {
        filmTextCache.update(filmText);
    }

    @Override
    public void delete(Short id) {
        filmTextCache.delete(id);
    }
}