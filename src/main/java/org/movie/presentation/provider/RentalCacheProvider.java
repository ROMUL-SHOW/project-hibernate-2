package org.movie.presentation.provider;

import org.movie.data.cache.RentalCache;
import org.movie.data.cache.RentalCacheImpl;
import org.movie.data.cache.RentalManager;
import org.movie.data.db.dao.RentalDAO;

public class RentalCacheProvider implements Provider<RentalCache> {
    @Override
    public RentalCache provide() {
        RentalManager rentalManager = new RentalManager(new RentalDAO());
        RentalCache rentalCache = new RentalCacheImpl(rentalManager);
        return rentalCache;
    }
}
