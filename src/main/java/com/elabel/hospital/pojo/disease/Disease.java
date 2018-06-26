package com.elabel.hospital.pojo.disease;

public class Disease {
    public Integer id;
    public Integer diseaseCategoryId;
    public String name;

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", diseaseCategoryId=" + diseaseCategoryId +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiseaseCategoryId() {
        return diseaseCategoryId;
    }

    public void setDiseaseCategoryId(Integer diseaseCategoryId) {
        this.diseaseCategoryId = diseaseCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
