package com.elabel.hospital.pojo.basic;

import java.sql.Timestamp;

public class Hospital {
    public  Integer id;
    public String name;
    public String address;
    public Timestamp clientLoginTime;


    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cloudLoginTime=" + clientLoginTime +
                '}';
    }

    public Timestamp getClientLoginTime() {
        return clientLoginTime;
    }

    public void setClientLoginTime(Timestamp clientLoginTime) {
        this.clientLoginTime = clientLoginTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
