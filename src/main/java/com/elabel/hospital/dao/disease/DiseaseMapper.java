package com.elabel.hospital.dao.disease;

import com.elabel.hospital.pojo.disease.Disease;
import com.elabel.hospital.pojo.disease.DiseaseCategory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DiseaseMapper {
    public void insertDisease(Disease disease);
    public void insertDiseaseCategory(DiseaseCategory diseaseCategory);
    public List<Disease> selectDisease(Map<String ,Object> params);
    public List<DiseaseCategory> selectDiseaseCategory(Map<String ,Object> params);
    public int updateDisease(Disease disease);
    public int updateDiseaseCategory(DiseaseCategory diseaseCategory);
    public int deleteDisease(Integer id);
    public int deleteDiseaseCategory(Integer id);
    public int selectCount();
    public int selectCountCategory();
}
