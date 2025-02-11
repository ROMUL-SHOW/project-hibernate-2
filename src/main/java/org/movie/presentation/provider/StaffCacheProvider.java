package org.movie.presentation.provider;

import org.movie.data.cache.StaffCache;
import org.movie.data.cache.StaffCacheImpl;
import org.movie.data.cache.StaffManager;
import org.movie.data.db.dao.StaffDAO;

public class StaffCacheProvider implements Provider<StaffCache> {

    @Override
    public StaffCache provide() {
        StaffManager staffManager = new StaffManager(new StaffDAO());
        StaffCache staffCache = new StaffCacheImpl(staffManager);
        return staffCache;
    }
}
