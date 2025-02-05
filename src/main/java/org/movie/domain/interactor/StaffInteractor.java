package org.movie.domain.interactor;

import org.movie.data.entity.Staff;
import org.movie.domain.repository.StaffRepository;

import java.util.List;

public class StaffInteractor {
    private final StaffRepository staffRepository;

    public StaffInteractor(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    public Staff findById(Byte id) {
        return staffRepository.findById(id);
    }

    public void save(Staff staff) {
        staffRepository.save(staff);
    }

    public void update(Staff staff) {
        staffRepository.update(staff);
    }

    public void delete(Byte id) {
        staffRepository.delete(id);
    }
}
