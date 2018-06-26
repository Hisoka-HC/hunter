package com.elabel.hospital.Task;

import com.elabel.hospital.service.patient.PatientService;
import com.elabel.hospital.util.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class PatientTask {

    @Resource
    PatientService patientService;

    Logger logger = new Logger(PatientTask.class, null, null);

    @Scheduled(cron = "0 0 1 * * ?")
    public void updatePatientStatus(){
        logger.log("updating  patient");
        patientService.updateStatusTask();
    }

    @PostConstruct
    public void init(){
        updatePatientStatus();
    }
}
