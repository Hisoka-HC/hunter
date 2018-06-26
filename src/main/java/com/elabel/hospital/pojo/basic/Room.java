package com.elabel.hospital.pojo.basic;

import java.util.List;

public class Room {
    public Integer id;
    public Integer hospitalId;
    public String name;
    public String code;
    public Integer floorId;
    public String floorName;
    public Integer bedCount;
    public List<Bed> bedList;
    public Integer departmentId;
    public Integer availableCount;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", hospitalId=" + hospitalId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", floorId=" + floorId +
                ", floorName='" + floorName + '\'' +
                ", bedCount=" + bedCount +
                ", bedList=" + bedList +
                ", departmentId=" + departmentId +
                ", availableCount=" + availableCount +
                '}';
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }


    public String getName() {
        return name;
    }

    public Integer getBedCount() {
        return bedCount;
    }

    public void setBedCount(Integer bedCount) {
        this.bedCount = bedCount;
    }

    public List<Bed> getBedList() {
        return bedList;
    }

    public void setBedList(List<Bed> bedList) {
        this.bedList = bedList;
    }
}
