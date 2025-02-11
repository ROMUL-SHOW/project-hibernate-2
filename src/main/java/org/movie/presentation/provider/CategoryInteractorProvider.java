package org.movie.presentation.provider;

import org.movie.domain.interactor.CategoryInteractor;

public class CategoryInteractorProvider implements Provider<CategoryInteractor> {

    @Override
    public CategoryInteractor provide() {
        CategoryRepositoryProvider categoryRepositoryProvider = new CategoryRepositoryProvider();
        CategoryInteractor categoryInteractor = new CategoryInteractor(categoryRepositoryProvider.provide());
        return categoryInteractor;
    }
}
