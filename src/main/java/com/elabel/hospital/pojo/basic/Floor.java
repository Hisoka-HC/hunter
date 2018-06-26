package com.elabel.hospital.pojo.basic;

import java.util.List;

public class Floor {
    public Integer id;
    public Integer hospitalId;
    public String name;
    public List<Room> roomList;
    public Integer roomCount;
    public Integer bedCount;
    public Integer availableCount;



    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", hospitalId=" + hospitalId +
                ", name='" + name + '\'' +
                ", roomList=" + roomList +
                ", roomCount=" + roomCount +
                ", bedCount=" + bedCount +
                ", availableCount=" + availableCount +
                '}';
    }
    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public Integer getBedCount() {
        return bedCount;
    }

    public void setBedCount(Integer bedCount) {
        this.bedCount = bedCount;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
