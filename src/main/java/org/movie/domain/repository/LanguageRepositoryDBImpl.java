package org.movie.domain.repository;

import org.movie.data.cache.LanguageCache;
import org.movie.data.entity.Language;

import java.util.List;

public class LanguageRepositoryDBImpl implements LanguageRepository {
    private final LanguageCache languageCache;

    public LanguageRepositoryDBImpl(LanguageCache languageCache) {
        this.languageCache = languageCache;
    }

    @Override
    public List<Language> findAll() {
        return languageCache.findAll();
    }

    @Override
    public Language findById(Byte id) {
        return languageCache.findById(id);
    }

    @Override
    public void save(Language language) {
        languageCache.save(language);
    }

    @Override
    public void update(Language language) {
        languageCache.update(language);
    }

    @Override
    public void delete(Byte id) {
        languageCache.delete(id);
    }
}
