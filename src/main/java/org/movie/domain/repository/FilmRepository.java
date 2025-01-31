package org.movie.domain.repository;

import org.movie.data.entity.Film;
import java.util.List;

public interface FilmRepository {
    List<Film> findAll();
    Film findById(Short id);
    void save(Film film);
    void update(Film film);
    void delete(Short id);
}
