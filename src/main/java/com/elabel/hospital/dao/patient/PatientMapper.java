package com.elabel.hospital.dao.patient;

import com.elabel.hospital.pojo.patient.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PatientMapper {
    /**
     * Ding : Auto load id. #2018-6-20
     */
    public int insertPatient(Patient patient);
    public  List<Patient>  selectPatient(Map<String ,Object> params);
    public int updatePatient(Patient patient);
    public int deletePatient(Integer id);
    public void updateStatusTask();
    public List<Patient> selectByStatus(Map<String ,Object> params);
    public List<Patient> selectPatientStatusIsUpdated();
    public void restoreNormal(Map<String ,Object> params);
    public int selectCount();

    /**
     * @author Ding
     */
    public void makeBed(Map<String, Object> params);
}
