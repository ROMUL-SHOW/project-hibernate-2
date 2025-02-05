package org.movie.domain.repository;

import org.movie.data.entity.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    Category findById(Byte id);
    void save(Category category);
    void update(Category category);
    void delete(Byte id);
}
