package com.elabel.hospital.service.client;

import com.elabel.hospital.pojo.basic.Department;
import com.elabel.hospital.pojo.basic.Floor;
import com.elabel.hospital.pojo.esl.Esl;
import com.elabel.hospital.pojo.patient.Patient;

import java.sql.Timestamp;
import java.util.List;

public interface ClientService {
    public void clientRefreshHospital(Integer name);
    public List selectByRequeirtment(String floorName,String departmentName,String roomName,String bedName,String patientName,String patientGender,Integer patientAge, String diseaseName,String keyword,String firstKeyword);
    public List selectPatientStatusIsUpdated();
    public void restoreNormal(int hospitalId);
    public List<Patient> selectPatient(Integer hospitalId,String status,String order);
    public List<Esl> selectUpdatedLabels(Integer hospitalId, Timestamp lastLoginTime, String order);
}
