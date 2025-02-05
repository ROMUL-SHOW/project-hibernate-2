package org.movie.data.cache;

import org.movie.data.db.dao.FilmTextDAO;
import org.movie.data.entity.FilmText;

import java.util.List;

public class FilmTextManager {
    private final FilmTextDAO filmTextDAO;

    public FilmTextManager(FilmTextDAO filmTextDAO) {
        this.filmTextDAO = filmTextDAO;
    }

    public List<FilmText> findAll() {
        return filmTextDAO.findAll();
    }

    public FilmText findById(Short id) {
        return filmTextDAO.findById(id);
    }

    public void save(FilmText filmText) {
        filmTextDAO.save(filmText);
    }

    public void update(FilmText filmText) {
        filmTextDAO.update(filmText);
    }

    public void delete(Short id) {
        filmTextDAO.delete(id);
    }
}
