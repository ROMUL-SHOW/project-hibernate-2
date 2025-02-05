package org.movie.data.cache;

import org.movie.data.entity.Staff;

import java.util.List;

public interface StaffCache {
    List<Staff> findAll();
    Staff findById(Byte id);
    void save(Staff staff);
    void update(Staff staff);
    void delete(Byte id);
}
