package org.movie.domain.repository;

import org.movie.data.entity.Staff;

import java.util.List;

public interface StaffRepository {
    List<Staff> findAll();
    Staff findById(Byte id);
    void save(Staff staff);
    void update(Staff staff);
    void delete(Byte id);
}
