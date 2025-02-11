package org.movie.presentation.provider;

import org.movie.domain.repository.RentalRepository;
import org.movie.domain.repository.RentalRepositoryDBImpl;

public class RentalRepositoryProvider implements Provider<RentalRepository> {
    @Override
    public RentalRepository provide() {
        RentalCacheProvider rentalCacheProvider = new RentalCacheProvider();
        RentalRepository rentalRepository = new RentalRepositoryDBImpl(rentalCacheProvider.provide());
        return rentalRepository;
    }
}
