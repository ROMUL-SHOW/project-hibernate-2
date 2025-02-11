package org.movie.presentation.provider;

import org.movie.domain.repository.CategoryRepository;
import org.movie.domain.repository.CategoryRepositoryDBImpl;

public class CategoryRepositoryProvider implements Provider<CategoryRepository> {

    @Override
    public CategoryRepository provide() {
        CategoryCacheProvider categoryCacheProvider = new CategoryCacheProvider();
        CategoryRepository categoryRepository = new CategoryRepositoryDBImpl(categoryCacheProvider.provide());
        return categoryRepository;
    }
}
