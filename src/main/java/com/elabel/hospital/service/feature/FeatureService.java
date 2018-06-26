package com.elabel.hospital.service.feature;

import com.elabel.hospital.pojo.feature.Allergy;
import com.elabel.hospital.pojo.feature.Eating;
import com.elabel.hospital.pojo.feature.NursingLevel;

import java.util.List;


public interface FeatureService {
    public void insertAllergy(Allergy allergy);
    public List<Allergy> selectAllergy();
    public void updateAllergy(Allergy allergy);
    public void deleteAllergy(Allergy allergy);
    public void insertEating(Eating eating);
    public List<Eating> selectEating();
    public void updateEating(Eating eating);
    public void deleteEating(Eating eating);
    public void insertNursingLevel(NursingLevel nursingLevel);
    public List<NursingLevel> selectNursingLevel();
    public void updateNursingLevel(NursingLevel nursingLevel);
    public void deleteNursingLevel(NursingLevel nursingLevel);
}
