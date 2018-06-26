package com.elabel.hospital.service.basic;

import com.elabel.hospital.pojo.basic.Hospital;

import java.util.List;

public interface HospitalService {

    public void insertHospital(Hospital hospital);
    public List<Hospital> selectHospital(String order, Integer limit, Integer offset);
    public int selectCount();
    public void updateHospital(Hospital hospital);
    public void deleteHospital(Integer id);
    public Hospital selectHospitalWhereKey(Integer key,String order);
}
