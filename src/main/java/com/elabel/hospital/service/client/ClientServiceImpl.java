package com.elabel.hospital.service.client;

import com.elabel.hospital.dao.basic.DepartmentMapper;
import com.elabel.hospital.dao.basic.HospitalMapper;
import com.elabel.hospital.dao.esl.EslMapper;
import com.elabel.hospital.dao.patient.PatientMapper;
import com.elabel.hospital.pojo.esl.Esl;
import com.elabel.hospital.pojo.patient.Patient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("clientService")
public class ClientServiceImpl implements ClientService{

    @Resource
    HospitalMapper hospitalMapper;

    @Resource
    EslMapper eslMapper;

    @Resource
    DepartmentMapper departmentMapper;

    @Resource
    PatientMapper patientMapper;

    @Override
    public void clientRefreshHospital(Integer name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name",name);
        hospitalMapper.clientRefreshHospital(params);
    }

    @Override
    public List selectByRequeirtment(String floorName,String departmentName,String roomName,String bedName,String patientName,String patientGender,Integer patientAge, String diseaseName,String keyword,String firstKeyword) {
        Map<String,Object> params = new HashMap<>();
        params.put("roomName",roomName);
        params.put("bedName",bedName);
        params.put("patientName",patientName);
        params.put("patientGender",patientGender);
        params.put("patientAge",patientAge);
        params.put("diseaseName",diseaseName);
        params.put("keyword",keyword);
        params.put("firstKeyword",firstKeyword);
        if (floorName!=null){
            params.put("floorName",floorName);
            return hospitalMapper.selectByFloor(params);
        }
        else {
            params.put("departmentName",departmentName);
            return departmentMapper.selectByDepartment(params);
        }

    }


    public List selectPatientStatusIsUpdated(){
       return patientMapper.selectPatientStatusIsUpdated();
    }

    @Override
    public void restoreNormal(int hospitalId) {
        Map params = new HashMap();
        params.put("hospitalId",hospitalId);
        patientMapper.restoreNormal(params);
    }

    @Override
    public List<Patient> selectPatient(Integer hospitalId, String status, String order) {
        Map params = new HashMap();
        params.put("hospitalId",hospitalId);
        params.put("status",status);
        params.put("order",order);
        return patientMapper.selectByStatus(params);
    }

    @Override
    public List<Esl> selectUpdatedLabels(Integer hospitalId, Timestamp lastLoginTime, String order) {
        Map params = new HashMap();
        params.put("hospitalId",hospitalId);
        params.put("lastLoginTime",lastLoginTime);
        params.put("order",order);
        return eslMapper.selectUpdatedLabels(params);
    }

}
