package com.elabel.hospital.pojo.patient;


import com.elabel.hospital.pojo.feature.Allergy;
import com.elabel.hospital.pojo.feature.Eating;
import com.elabel.hospital.pojo.feature.NursingLevel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Patient {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public Integer id;
    public Integer age;
    public String bedName;
    public Integer allergyId;
    public String allergyName;
    public Integer eatingId;
    public String eatingName;
    public Integer barcode;
    public Integer nursingLevelId;
    public String nursingLevelName;
    public Integer staffId1;
    public String staff1Name;
    public Integer staffId2;
    public String staff2Name;
    public Integer departmentId;
    public String departmentName;
    public Integer hospitalId;
    public Integer diseaseId;
    public Integer bedId;
    public String name;
    public String gender;
    public String status;
    public Timestamp admittedTime;
    public Timestamp currentTime;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", age=" + age +
                ", bedName='" + bedName + '\'' +
                ", allergyId=" + allergyId +
                ", allergyName='" + allergyName + '\'' +
                ", eatingId=" + eatingId +
                ", eatingName='" + eatingName + '\'' +
                ", barcode=" + barcode +
                ", nursingLevelId=" + nursingLevelId +
                ", nursingLevelName='" + nursingLevelName + '\'' +
                ", staffId1=" + staffId1 +
                ", staff1Name='" + staff1Name + '\'' +
                ", staffId2=" + staffId2 +
                ", staff2Name='" + staff2Name + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", hospitalId=" + hospitalId +
                ", diseaseId=" + diseaseId +
                ", bedId=" + bedId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                ", admittedTime=" + admittedTime +
                ", currentTime=" + currentTime +
                '}';
    }

    public String getCurrentTime() {
        Calendar calender = Calendar.getInstance();
        Date date = new Date();
        calender.setTime(date);
        return  DATE_FORMAT.format(calender.getTime());
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getBedName() {
        return bedName;
    }

    public void setBedName(String bedName) {
        this.bedName = bedName;
    }

    public String getStaff1Name() {
        return staff1Name;
    }

    public void setStaff1Name(String staff1Name) {
        this.staff1Name = staff1Name;
    }

    public String getStaff2Name() {
        return staff2Name;
    }

    public void setStaff2Name(String staff2Name) {
        this.staff2Name = staff2Name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(Integer allergyId) {
        this.allergyId = allergyId;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    public Integer getEatingId() {
        return eatingId;
    }

    public void setEatingId(Integer eatingId) {
        this.eatingId = eatingId;
    }

    public String getEatingName() {
        return eatingName;
    }

    public void setEatingName(String eatingName) {
        this.eatingName = eatingName;
    }

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public Integer getNursingLevelId() {
        return nursingLevelId;
    }

    public void setNursingLevelId(Integer nursingLevelId) {
        this.nursingLevelId = nursingLevelId;
    }

    public String getNursingLevelName() {
        return nursingLevelName;
    }

    public void setNursingLevelName(String nursingLevelName) {
        this.nursingLevelName = nursingLevelName;
    }

    public Integer getStaffId1() {
        return staffId1;
    }

    public void setStaffId1(Integer staffId1) {
        this.staffId1 = staffId1;
    }

    public Integer getStaffId2() {
        return staffId2;
    }

    public void setStaffId2(Integer staffId2) {
        this.staffId2 = staffId2;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdmittedTime() {
        if (admittedTime == null)
            return null;
        return DATE_FORMAT.format(admittedTime);
    }

    public void setAdmittedTime(String admittedTime) {
        try {
            if (admittedTime != null)
                this.admittedTime = new Timestamp(DATE_FORMAT.parse(admittedTime).getTime());
        } catch (ParseException e) {
            try {
                this.admittedTime = new Timestamp(DATE_FORMAT.parse(admittedTime + " 23:59").getTime());
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
    }
}
