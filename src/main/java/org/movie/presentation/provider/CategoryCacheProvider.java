package org.movie.presentation.provider;

import org.movie.data.cache.CategoryCache;
import org.movie.data.cache.CategoryCacheImpl;
import org.movie.data.cache.CategoryManager;
import org.movie.data.db.dao.CategoryDAO;

public class CategoryCacheProvider implements Provider<CategoryCache> {

    @Override
    public CategoryCache provide() {
        CategoryManager categoryManager = new CategoryManager(new CategoryDAO());
        CategoryCache categoryCache = new CategoryCacheImpl(categoryManager);
        return categoryCache;
    }
}
