package org.movie.data.cache;

import org.movie.data.entity.FilmText;

import java.util.List;

public interface FilmTextCache {
    List<FilmText> findAll();
    FilmText findById(Short id);
    void save(FilmText filmText);
    void update(FilmText filmText);
    void delete(Short id);
}
