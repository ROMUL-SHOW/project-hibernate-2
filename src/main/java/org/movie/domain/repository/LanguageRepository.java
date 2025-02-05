package org.movie.domain.repository;

import org.movie.data.entity.Language;

import java.util.List;

public interface LanguageRepository {
    List<Language> findAll();

    Language findById(Byte id);

    void save(Language language);

    void update(Language language);

    void delete(Byte id);
}
