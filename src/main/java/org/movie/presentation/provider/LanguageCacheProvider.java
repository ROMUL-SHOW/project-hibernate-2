package org.movie.presentation.provider;

import org.movie.data.cache.LanguageCache;
import org.movie.data.cache.LanguageCacheImpl;
import org.movie.data.cache.LanguageManager;
import org.movie.data.db.dao.LanguageDAO;

public class LanguageCacheProvider implements Provider<LanguageCache> {

    @Override
    public LanguageCache provide() {
        LanguageManager languageManager = new LanguageManager(new LanguageDAO());
        LanguageCache languageCache = new LanguageCacheImpl(languageManager);
        return languageCache;
    }
}
