package org.movie.data.cache;

import org.movie.data.entity.Language;

import java.util.List;

public class LanguageCacheImpl implements LanguageCache {
    private final LanguageManager languageManager;

    public LanguageCacheImpl(LanguageManager languageManager) {
        this.languageManager = languageManager;
    }

    @Override
    public List<Language> findAll() {
        return languageManager.findAll();
    }

    @Override
    public Language findById(Byte id) {
        return languageManager.findById(id);
    }

    @Override
    public void save(Language language) {
        languageManager.save(language);
    }

    @Override
    public void update(Language language) {
        languageManager.update(language);
    }

    @Override
    public void delete(Byte id) {
        languageManager.delete(id);
    }
}