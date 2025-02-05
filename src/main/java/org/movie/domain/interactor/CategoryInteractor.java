package org.movie.domain.interactor;

import org.movie.data.entity.Category;
import org.movie.domain.repository.CategoryRepository;

import java.util.List;

public class CategoryInteractor {
    private final CategoryRepository categoryRepository;

    public CategoryInteractor(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Byte id) {
        return categoryRepository.findById(id);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void update(Category category) {
        categoryRepository.update(category);
    }

    public void delete(Byte id) {
        categoryRepository.delete(id);
    }
}
