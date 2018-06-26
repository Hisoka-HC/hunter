package com.elabel.hospital.service.patient;

import com.elabel.hospital.dao.esl.EslMapper;
import com.elabel.hospital.dao.patient.PatientMapper;
import com.elabel.hospital.pojo.patient.Patient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("patientService")
public class PatientServiceImpl implements PatientService {

    @Resource
    PatientMapper patientMapper;

    @Resource
    EslMapper eslMapper;

    @Override
    public void insertPatient(Patient patient) {
        patientMapper.insertPatient(patient);
        this.updatePatient(patient);
    }

    @Override
    public  List<Patient>  selectPatient(Integer departmentId,Integer bedId, String order, Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("order",order);
        params.put("limit",limit);
        params.put("offset",offset);
        params.put("bedId",bedId);
        params.put("departmentId",departmentId);
        return patientMapper.selectPatient(params);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientMapper.updatePatient(patient);
        Integer bedId = patient.bedId;
        Map<String,Object> params = new HashMap();
        params.put("bedId",bedId);
        eslMapper.updateEslTime(params);
    }

    @Override
    public void updateStatusTask() {
        patientMapper.updateStatusTask();
    }

    @Override
    public void deletePatient(Integer id) {
        patientMapper.deletePatient(id);
    }

    @Override
    public List<Patient> selectByStatus(String status) {
        Map<String,Object> params = new HashMap();
        params.put("status",status);
        return  patientMapper.selectByStatus(params);
    }

    @Override
    public int selectCount() {
        return patientMapper.selectCount();
    }
}
