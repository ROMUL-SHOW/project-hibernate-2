package org.movie.domain.interactor;

import org.movie.domain.repository.FilmRepository;
import org.movie.data.entity.Film;
import java.util.List;

public class FilmInteractor {
    private final FilmRepository filmRepository;

    public FilmInteractor(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    public List<Film> findAll() {
        return filmRepository.findAll();
    }
    public Film findById(Short id) {
        return filmRepository.findById(id);
    }
    public void save(Film film) {
        filmRepository.save(film);
    }
    public void delete(Short id) {
        filmRepository.delete(id);
    }
    public void update(Film film) {
        filmRepository.update(film);
    }
}
