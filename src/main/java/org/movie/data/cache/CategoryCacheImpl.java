package org.movie.data.cache;

import org.movie.data.entity.Category;

import java.util.List;

public class CategoryCacheImpl implements CategoryCache {
    private final CategoryManager categoryManager;

    public CategoryCacheImpl(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

    @Override
    public List<Category> findAll() {
        return categoryManager.findAll();
    }

    @Override
    public Category findById(Byte id) {
        return categoryManager.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryManager.save(category);
    }

    @Override
    public void update(Category category) {
        categoryManager.update(category);
    }

    @Override
    public void delete(Byte id) {
        categoryManager.delete(id);
    }
}
