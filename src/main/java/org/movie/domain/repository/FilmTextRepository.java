package org.movie.domain.repository;

import org.movie.data.entity.FilmText;

import java.util.List;

public interface FilmTextRepository {
    List<FilmText> findAll();
    FilmText findById(Short id);
    void save(FilmText filmText);
    void update(FilmText filmText);
    void delete(Short id);
}
