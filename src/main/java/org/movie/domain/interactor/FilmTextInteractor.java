package org.movie.domain.interactor;

import org.movie.data.entity.FilmText;
import org.movie.domain.repository.FilmTextRepository;

import java.util.List;

public class FilmTextInteractor {
    private final FilmTextRepository filmTextRepository;

    public FilmTextInteractor(FilmTextRepository filmTextRepository) {
        this.filmTextRepository = filmTextRepository;
    }

    public List<FilmText> findAll() {
        return filmTextRepository.findAll();
    }

    public FilmText findById(Short id) {
        return filmTextRepository.findById(id);
    }

    public void save(FilmText filmText) {
        filmTextRepository.save(filmText);
    }

    public void update(FilmText filmText) {
        filmTextRepository.update(filmText);
    }

    public void delete(Short id) {
        filmTextRepository.delete(id);
    }
}
