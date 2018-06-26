package com.elabel.hospital.service.basic;

import com.elabel.hospital.dao.basic.BedMapper;
import com.elabel.hospital.dao.esl.EslMapper;
import com.elabel.hospital.dao.patient.PatientMapper;
import com.elabel.hospital.pojo.basic.Bed;
import com.elabel.hospital.pojo.patient.Patient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bedService")
public class BedServiceImpl implements BedService {
    @Resource
    BedMapper bedMapper;

    @Resource
    PatientMapper patientMapper;

    @Resource
    EslMapper eslMapper;

    @Override
    public void insertBed(Bed bed) {
        bedMapper.insertBed(bed);
    }

    @Override
    public List<Bed> selectBed(Integer floorId, Integer roomId, Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("floorId", floorId);
        params.put("roomId", roomId);
        params.put("limit", limit);
        params.put("offset", offset);
        return bedMapper.selectBed(params);
    }

    @Override
    public int selectCount(Integer floorId, Integer roomId) {
        Map params = new HashMap();
        params.put("floorId", floorId);
        params.put("roomId", roomId);
        return bedMapper.selectCount(params);
    }

    @Override
    public void updateBed(Bed bed) {


        bedMapper.updateBed(bed);
        Integer bedId = bed.id;
        Map params = new HashMap();
        params.put("bedId",bedId);
        eslMapper.updateEslTime(params);
    }

    @Override
    public void deleteBed(Integer id) {
        bedMapper.deleteBed(id);
    }
}
