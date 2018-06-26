package com.elabel.hospital.service.staff;

import com.elabel.hospital.pojo.staff.Staff;

import java.util.List;

public interface StaffService {
    public void insertStaff(Staff staff);
    public List<Staff> selectStaff(String order, Integer limit, Integer offset);
    public void updateStaff(Staff staff);
    public void deleteStaff(Integer id);
    public int selectCount();
}
