package org.movie.domain.interactor;

import org.movie.data.entity.Store;
import org.movie.domain.repository.StoreRepository;

import java.util.List;

public class StoreInteractor {
    private final StoreRepository storeRepository;

    public StoreInteractor(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Store findById(Byte id) {
        return storeRepository.findById(id);
    }

    public void save(Store store) {
        storeRepository.save(store);
    }

    public void update(Store store) {
        storeRepository.update(store);
    }

    public void delete(Byte id) {
        storeRepository.delete(id);
    }
}
