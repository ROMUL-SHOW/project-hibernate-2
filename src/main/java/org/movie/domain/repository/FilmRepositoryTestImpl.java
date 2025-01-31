package org.movie.domain.repository;

import org.movie.data.entity.Film;
import java.util.ArrayList;
import java.util.List;

import static org.movie.data.entity.Rating.PG13;

public class FilmRepositoryTestImpl implements FilmRepository {
    @Override
    public List<Film> findAll() {
        Film film = new Film();
        film.setTitle("Film Title");
        film.setRating(PG13);
        List<Film> films = new ArrayList<>();
        films.add(film);
        return films;
    }

    @Override
    public Film findById(Short id) {
        return null;
    }

    @Override
    public void save(Film film) {

    }

    @Override
    public void update(Film film) {

    }

    @Override
    public void delete(Short id) {

    }
}
