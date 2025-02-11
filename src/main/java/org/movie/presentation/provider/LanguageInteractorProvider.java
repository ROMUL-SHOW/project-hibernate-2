package org.movie.presentation.provider;

import org.movie.domain.interactor.LanguageInteractor;

public class LanguageInteractorProvider implements Provider<LanguageInteractor> {

    @Override
    public LanguageInteractor provide() {
        LanguageRepositoryProvider repositoryProvider = new LanguageRepositoryProvider();
        LanguageInteractor languageInteractor = new LanguageInteractor(repositoryProvider.provide());
        return languageInteractor;
    }
}
