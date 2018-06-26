package com.elabel.hospital.pojo.basic;

import com.elabel.hospital.pojo.patient.Patient;

public class Bed {
    public Integer id;
    public Integer roomId;
    public Integer hospitalId;
    public Integer floorId;
    public String roomName;
    public String floorName;
    public Patient patient;
    public String name;
    public Boolean available;

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", hospitalId=" + hospitalId +
                ", floorId=" + floorId +
                ", roomName='" + roomName + '\'' +
                ", floorName='" + floorName + '\'' +
                ", patient=" + patient +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
