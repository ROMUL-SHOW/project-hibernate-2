package org.movie.data.cache;

import org.movie.data.entity.Language;

import java.util.List;

public interface LanguageCache {
    List<Language> findAll();

    Language findById(Byte id);

    void save(Language language);

    void update(Language language);

    void delete(Byte id);
}
