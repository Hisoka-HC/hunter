package com.elabel.hospital.service.basic;

import com.elabel.hospital.dao.basic.DepartmentMapper;
import com.elabel.hospital.pojo.basic.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    DepartmentMapper departmentMapper;

    @Override
    public void insertDepartment(Department department) {
        departmentMapper.insertDepartment(department);
    }

    @Override
    public List<Department> selectDepartment(String order, Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("order",order);
        params.put("limit",limit);
        params.put("offset",offset);
        return departmentMapper.selectDepartment(params);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentMapper.deleteDepartment(id);
    }

    @Override
    public int selectCount() {
        return departmentMapper.selectCount();
    }

    @Override
    public Department selectWhereByKey(Integer departmentId) {
        Map params = new HashMap();
        params.put("departmentId",departmentId);
        return departmentMapper.selectWhereByKey(params);
    }
}
