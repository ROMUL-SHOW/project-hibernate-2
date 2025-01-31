package org.movie.data.cache;

import org.movie.data.db.dao.FilmDAO;
import org.movie.data.entity.Film;
import java.util.List;

public class FilmManager {
    private final FilmDAO filmDAO;

    public FilmManager(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    public List<Film> getAll() {
        return filmDAO.findAll();
    }

    public Film findById(Short id) {
        return filmDAO.findById(id);
    }

    public void save(Film film) {
        filmDAO.save(film);
    }

    public void update(Film film) {
        filmDAO.update(film);
    }

    public void delete(Short id) {
       filmDAO.delete(id);
    }
}
