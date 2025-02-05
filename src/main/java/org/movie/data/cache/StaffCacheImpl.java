package org.movie.data.cache;

import org.movie.data.entity.Staff;

import java.util.List;

public class StaffCacheImpl implements StaffCache {
    private final StaffManager staffManager;

    public StaffCacheImpl(StaffManager staffManager) {
        this.staffManager = staffManager;
    }

    @Override
    public List<Staff> findAll() {
        return staffManager.findAll();
    }

    @Override
    public Staff findById(Byte id) {
        return staffManager.findById(id);
    }

    @Override
    public void save(Staff staff) {
        staffManager.save(staff);
    }

    @Override
    public void update(Staff staff) {
        staffManager.update(staff);
    }

    @Override
    public void delete(Byte id) {
        staffManager.delete(id);
    }
}
