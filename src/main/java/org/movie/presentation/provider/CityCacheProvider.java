package org.movie.presentation.provider;

import org.movie.data.cache.CityCache;
import org.movie.data.cache.CityCacheImpl;
import org.movie.data.cache.CityManager;
import org.movie.data.db.dao.CityDAO;

public class CityCacheProvider implements Provider<CityCache> {

    @Override
    public CityCache provide() {
        CityManager cityManager = new CityManager(new CityDAO());
        CityCache cityCache = new CityCacheImpl(cityManager);
        return cityCache;
    }
}
