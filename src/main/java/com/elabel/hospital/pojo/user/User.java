package com.elabel.hospital.pojo.user;

public class User {

    public Integer id;
    public Integer hospitalId;
    public String email;
    public String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", hospitalId=" + hospitalId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHospital_id(Integer hospital_id) {
        this.hospitalId = hospital_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public Integer getHospital_id() {
        return hospitalId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
