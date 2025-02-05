package org.movie.data.cache;

import org.movie.data.db.dao.CategoryDAO;
import org.movie.data.entity.Category;

import java.util.List;

public class CategoryManager {
    private final CategoryDAO categoryDAO;

    public CategoryManager(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    public Category findById(Byte id) {
        return categoryDAO.findById(id);
    }

    public void save(Category category) {
        categoryDAO.save(category);
    }

    public void update(Category category) {
        categoryDAO.update(category);
    }

    public void delete(Byte id) {
        categoryDAO.delete(id);
    }

}
