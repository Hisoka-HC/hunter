package com.elabel.hospital.dao.staff;

import com.elabel.hospital.pojo.staff.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StaffMapper {
    public int insertStaff(Staff staff);
    public List<Staff> selectStaff(Map<String ,Object> params);
    public int updateStaff(Staff staff);
    public int deleteStaff(Integer id);
    public int selectCount();
}
