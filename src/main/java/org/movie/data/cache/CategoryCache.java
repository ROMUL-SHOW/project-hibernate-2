package org.movie.data.cache;

import org.movie.data.entity.Category;

import java.util.List;

public interface CategoryCache {
    List<Category> findAll();
    Category findById(Byte id);
    void save(Category category);
    void update(Category category);
    void delete(Byte id);
}
