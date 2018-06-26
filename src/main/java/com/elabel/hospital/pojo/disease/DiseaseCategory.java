package com.elabel.hospital.pojo.disease;

import java.util.List;

public class DiseaseCategory {
    public Integer id;
    public Integer hospitalId;
    public String name;
    public Integer superiorCategoryId;
    public List subDiseaseCategoryList;
    public List subDiseaseList;
    public String description;

    @Override
    public String toString() {
        return "DiseaseCategory{" +
                "id=" + id +
                ", hospitalId=" + hospitalId +
                ", name='" + name + '\'' +
                ", superiorCategoryId=" + superiorCategoryId +
                ", subDiseaseCategoryList=" + subDiseaseCategoryList +
                ", subDiseaseList=" + subDiseaseList +
                ", description='" + description + '\'' +
                '}';
    }

    public List getSubDiseaseCategoryList() {
        return subDiseaseCategoryList;
    }

    public void setSubDiseaseCategoryList(List subDiseaseCategoryList) {
        this.subDiseaseCategoryList = subDiseaseCategoryList;
    }

    public List getSubDiseaseList() {
        return subDiseaseList;
    }

    public void setSubDiseaseList(List subDiseaseList) {
        this.subDiseaseList = subDiseaseList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getSuperiorCategoryId() {
        return superiorCategoryId;
    }

    public void setSuperiorCategoryId(Integer superiorCategoryId) {
        this.superiorCategoryId = superiorCategoryId;
    }
}
