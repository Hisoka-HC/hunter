package com.elabel.hospital.service.patient;

import com.elabel.hospital.pojo.patient.Patient;

import java.util.List;

public interface PatientService {
    public void insertPatient(Patient patient);
    public List<Patient> selectPatient(Integer departmentId,Integer bedId, String order, Integer limit, Integer offset);
    public void updatePatient(Patient patient);
    public void updateStatusTask();
    public void deletePatient(Integer id);
    public List<Patient> selectByStatus(String status);
    public int selectCount();
}
