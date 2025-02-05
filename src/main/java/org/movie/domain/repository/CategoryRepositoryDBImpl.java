package org.movie.domain.repository;

import org.movie.data.cache.CategoryCache;
import org.movie.data.entity.Category;

import java.util.List;

public class CategoryRepositoryDBImpl implements CategoryRepository {

    private final CategoryCache categoryCache;
    public CategoryRepositoryDBImpl(CategoryCache categoryCache) {
        this.categoryCache = categoryCache;
    }

    @Override
    public List<Category> findAll() {
        return categoryCache.findAll();
    }

    @Override
    public Category findById(Byte id) {
        return categoryCache.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryCache.save(category);
    }

    @Override
    public void update(Category category) {
        categoryCache.update(category);
    }

    @Override
    public void delete(Byte id) {
        categoryCache.delete(id);
    }
}
