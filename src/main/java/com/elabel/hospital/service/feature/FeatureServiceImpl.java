package com.elabel.hospital.service.feature;


import com.elabel.hospital.dao.feature.FeatureMapper;
import com.elabel.hospital.pojo.feature.Allergy;
import com.elabel.hospital.pojo.feature.Eating;
import com.elabel.hospital.pojo.feature.NursingLevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("featureService")
public class FeatureServiceImpl implements FeatureService {
    @Resource
    FeatureMapper featureMapper;

    @Override
    public void insertAllergy(Allergy allergy) {
        featureMapper.insertAllergy(allergy);
    }

    @Override
    public List<Allergy> selectAllergy() {
        return featureMapper.selectAllergy();
    }

    @Override
    public void updateAllergy(Allergy allergy) {
        featureMapper.updateAllergy(allergy);
    }

    @Override
    public void deleteAllergy(Allergy allergy) {
        featureMapper.deleteAllergy(allergy);
    }

    @Override
    public void insertEating(Eating eating) {
        featureMapper.insertEating(eating);
    }

    @Override
    public List<Eating> selectEating() {
        return featureMapper.selectEating();
    }

    @Override
    public void updateEating(Eating eating) {
        featureMapper.updateEating(eating);
    }

    @Override
    public void deleteEating(Eating eating) {
        featureMapper.deleteEating(eating);
    }

    @Override
    public void insertNursingLevel(NursingLevel nursingLevel) {
        featureMapper.insertNursingLevel(nursingLevel);
    }

    @Override
    public List<NursingLevel> selectNursingLevel() {
        return featureMapper.selectNursingLevel();
    }

    @Override
    public void updateNursingLevel(NursingLevel nursingLevel) {
        featureMapper.updateNursingLevel(nursingLevel);
    }

    @Override
    public void deleteNursingLevel(NursingLevel nursingLevel) {
        featureMapper.deleteNursingLevel(nursingLevel);
    }
}
