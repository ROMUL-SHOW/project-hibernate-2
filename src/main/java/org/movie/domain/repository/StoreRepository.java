package org.movie.domain.repository;

import org.movie.data.entity.Store;

import java.util.List;

public interface StoreRepository {
    List<Store> findAll();
    Store findById(Byte id);
    void save(Store store);
    void update(Store store);
    void delete(Byte id);
}
