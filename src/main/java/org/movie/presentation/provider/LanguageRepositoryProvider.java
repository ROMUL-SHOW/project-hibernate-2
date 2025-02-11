package org.movie.presentation.provider;

import org.movie.domain.repository.LanguageRepository;
import org.movie.domain.repository.LanguageRepositoryDBImpl;

public class LanguageRepositoryProvider implements Provider<LanguageRepository> {

    @Override
    public LanguageRepository provide() {
        LanguageCacheProvider languageCacheProvider = new LanguageCacheProvider();
        LanguageRepository languageRepository = new LanguageRepositoryDBImpl(languageCacheProvider.provide());
        return languageRepository;
    }
}
