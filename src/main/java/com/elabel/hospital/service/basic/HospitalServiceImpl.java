package com.elabel.hospital.service.basic;

import com.elabel.hospital.dao.basic.HospitalMapper;
import com.elabel.hospital.pojo.basic.Hospital;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {
    @Resource
    HospitalMapper hospitalMapper;


    @Override
    public void insertHospital(Hospital hospital) {
        hospitalMapper.insertHospital(hospital);
    }

    @Override
    public List<Hospital> selectHospital(String order, Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("order",order);
        params.put("limit",limit);
        params.put("offset",offset);
        return hospitalMapper.selectHospital(params);
    }

    @Override
    public int selectCount() {
        return hospitalMapper.selectCount();
    }

    @Override
    public void updateHospital(Hospital hospital) {
        hospitalMapper.updateHospital(hospital);
    }

    @Override
    public void deleteHospital(Integer id) {
        hospitalMapper.deleteHospital(id);
    }

    @Override
    public Hospital selectHospitalWhereKey(Integer key, String order) {
        Map<String,Object> params = new HashMap();
        params.put("key",key);
        params.put("order",order);

        return hospitalMapper.selectHospitalWhereKey(params);
    }

}
