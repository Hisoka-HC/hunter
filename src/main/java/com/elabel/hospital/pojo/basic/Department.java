package com.elabel.hospital.pojo.basic;

import java.sql.Timestamp;
import java.util.List;

public class Department {
    public Integer id;
    public Integer hospitalId;
    public String name;
    public List<Room> roomList;
    public Timestamp clientLoginTime;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", hospitalId=" + hospitalId +
                ", name='" + name + '\'' +
                ", roomList=" + roomList +
                ", timestamp=" + clientLoginTime +
                '}';
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public Timestamp getTimestamp() {
        return clientLoginTime;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.clientLoginTime = timestamp;
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
