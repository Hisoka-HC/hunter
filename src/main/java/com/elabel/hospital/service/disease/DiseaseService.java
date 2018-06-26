package com.elabel.hospital.service.disease;

import com.elabel.hospital.pojo.disease.Disease;
import com.elabel.hospital.pojo.disease.DiseaseCategory;

import java.util.List;

public interface DiseaseService {
    public void insertDisease(Disease disease);
    public void insertDiseaseCategory(DiseaseCategory diseaseCategory);
    public List<Disease> selectDisease(String order, Integer limit, Integer offset);
    public List<DiseaseCategory> selectDiseaseCategory(String order, Integer limit, Integer offset);
    public void updateDisease(Disease disease);
    public void updateDiseaseCategory(DiseaseCategory diseaseCategory);
    public void deleteDisease(Integer id);
    public void deleteDiseaseCategory(Integer id);
    public int selectCount();
    public int selectCountCategory();
}
