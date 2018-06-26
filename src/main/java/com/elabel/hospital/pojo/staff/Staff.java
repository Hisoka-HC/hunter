package com.elabel.hospital.pojo.staff;

public class Staff {
    public Integer id;
    public Integer positionId;
    public Integer superiorId;
    public Integer departmentId;
    public String name;

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", positionId=" + positionId +
                ", superiorId=" + superiorId +
                ", departmentId=" + departmentId +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Integer superiorId) {
        this.superiorId = superiorId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
