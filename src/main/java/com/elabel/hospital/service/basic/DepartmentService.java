package com.elabel.hospital.service.basic;

import com.elabel.hospital.pojo.basic.Department;

import java.util.List;

public interface DepartmentService {
    public void insertDepartment(Department department);
    public List<Department> selectDepartment(String order, Integer limit, Integer offset);
    public void updateDepartment(Department department);
    public void deleteDepartment(Integer id);
    public int selectCount();
    public Department selectWhereByKey(Integer departmentId);
}
