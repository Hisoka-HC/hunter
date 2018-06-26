package com.elabel.hospital.service.staff;

import com.elabel.hospital.dao.staff.StaffMapper;
import com.elabel.hospital.pojo.staff.Staff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Resource
    StaffMapper staffMapper;

    @Override
    public void insertStaff(Staff staff) {
        staffMapper.insertStaff(staff);
    }

    @Override
    public List<Staff> selectStaff(String order, Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("order",order);
        params.put("limit",limit);
        params.put("offset",offset);
        return staffMapper.selectStaff(params);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffMapper.updateStaff(staff);
    }

    @Override
    public void deleteStaff(Integer id) {
        staffMapper.deleteStaff(id);
    }

    @Override
    public int selectCount() {
        return staffMapper.selectCount();
    }
}
