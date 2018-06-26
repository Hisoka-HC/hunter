package com.elabel.hospital.pojo.feature;

public class Allergy {

    public Integer id;
    public String name;
    public Integer patientId;

    @Override
    public String toString() {
        return "Allergy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", patientId=" + patientId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
}
