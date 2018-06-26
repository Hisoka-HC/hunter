package com.elabel.hospital.dao.basic;

import com.elabel.hospital.pojo.basic.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DepartmentMapper {
    public int insertDepartment(Department department);
    public List<Department> selectDepartment(Map<String ,Object> params);
    public int updateDepartment(Department department);
    public int deleteDepartment(Integer id);
    public List<Department> selectByDepartment(Map<String, Object> params);
    public int selectCount();
    public Department selectWhereByKey(Map<String, Object> params);
}
