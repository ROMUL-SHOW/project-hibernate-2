package org.movie.domain.repository;

import org.movie.data.cache.StaffCache;
import org.movie.data.entity.Staff;

import java.util.List;

public class StaffRepositoryDBImpl implements StaffRepository {
    private final StaffCache staffCache;

    public StaffRepositoryDBImpl(StaffCache staffCache) {
        this.staffCache = staffCache;
    }

    @Override
    public List<Staff> findAll() {
        return staffCache.findAll();
    }

    @Override
    public Staff findById(Byte id) {
        return staffCache.findById(id);
    }

    @Override
    public void save(Staff staff) {
        staffCache.save(staff);
    }

    @Override
    public void update(Staff staff) {
        staffCache.update(staff);
    }

    @Override
    public void delete(Byte id) {
        staffCache.delete(id);
    }
}
