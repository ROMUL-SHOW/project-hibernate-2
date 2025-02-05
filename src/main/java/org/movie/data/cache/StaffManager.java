package org.movie.data.cache;

import org.movie.data.db.dao.StaffDAO;
import org.movie.data.entity.Staff;

import java.util.List;

public class StaffManager {
    private final StaffDAO staffDAO;

    public StaffManager(StaffDAO staffDAO) {
        this.staffDAO = staffDAO;
    }

    public List<Staff> findAll() {
        return staffDAO.findAll();
    }

    public Staff findById(Byte id) {
        return staffDAO.findById(id);
    }

    public void save(Staff staff) {
        staffDAO.save(staff);
    }

    public void update(Staff staff) {
        staffDAO.update(staff);
    }

    public void delete(Byte id) {
        staffDAO.delete(id);
    }
}