package com.elabel.hospital.service.disease;

import com.elabel.hospital.dao.disease.DiseaseMapper;
import com.elabel.hospital.pojo.disease.Disease;
import com.elabel.hospital.pojo.disease.DiseaseCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("diseaseService")
public class DiseaseServiceImpl implements DiseaseService {

    @Resource
    DiseaseMapper diseaseMapper;

    @Override
    public void insertDisease(Disease disease) {
        diseaseMapper.insertDisease(disease);
    }

    @Override
    public void insertDiseaseCategory(DiseaseCategory diseaseCategory) {
        diseaseMapper.insertDiseaseCategory(diseaseCategory);
    }

    @Override
    public List<Disease> selectDisease(String order, Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("order",order);
        params.put("limit",limit);
        params.put("offset",offset);
        return diseaseMapper.selectDisease(params);
    }

    @Override
    public List<DiseaseCategory> selectDiseaseCategory(String order, Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("order",order);
        params.put("limit",limit);
        params.put("offset",offset);
        return diseaseMapper.selectDiseaseCategory(params);

    }

    @Override
    public void updateDisease(Disease disease) {
        diseaseMapper.updateDisease(disease);
    }

    @Override
    public void updateDiseaseCategory(DiseaseCategory diseaseCategory) {
        diseaseMapper.insertDiseaseCategory(diseaseCategory);
    }

    @Override
    public void deleteDisease(Integer id) {
        diseaseMapper.deleteDisease(id);
    }

    @Override
    public void deleteDiseaseCategory(Integer id) {
        diseaseMapper.deleteDiseaseCategory(id);
    }

    @Override
    public int selectCount() {
        return diseaseMapper.selectCount();
    }

    @Override
    public int selectCountCategory() {
        return diseaseMapper.selectCountCategory();
    }
}
