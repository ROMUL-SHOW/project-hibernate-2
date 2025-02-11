package org.movie.presentation.provider;

import org.movie.domain.repository.StaffRepository;
import org.movie.domain.repository.StaffRepositoryDBImpl;

public class StaffRepositoryProvider implements Provider<StaffRepository> {

    @Override
    public StaffRepository provide() {
        StaffCacheProvider staffCacheProvider = new StaffCacheProvider();
        StaffRepository staffRepository = new StaffRepositoryDBImpl(staffCacheProvider.provide());
        return staffRepository;
    }
}
