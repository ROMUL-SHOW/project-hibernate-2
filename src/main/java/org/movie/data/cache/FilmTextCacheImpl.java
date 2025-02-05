package org.movie.data.cache;

import org.movie.data.entity.FilmText;

import java.util.List;

public class FilmTextCacheImpl implements FilmTextCache {
    private final FilmTextManager filmTextManager;

    public FilmTextCacheImpl(FilmTextManager filmTextManager) {
        this.filmTextManager = filmTextManager;
    }

    @Override
    public List<FilmText> findAll() {
        return filmTextManager.findAll();
    }

    @Override
    public FilmText findById(Short id) {
        return filmTextManager.findById(id);
    }

    @Override
    public void save(FilmText filmText) {
        filmTextManager.save(filmText);
    }

    @Override
    public void update(FilmText filmText) {
        filmTextManager.update(filmText);
    }

    @Override
    public void delete(Short id) {
        filmTextManager.delete(id);
    }
}
