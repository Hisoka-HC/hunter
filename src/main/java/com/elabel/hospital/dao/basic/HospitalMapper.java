package com.elabel.hospital.dao.basic;

        import com.elabel.hospital.pojo.basic.Floor;
        import com.elabel.hospital.pojo.basic.Hospital;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Map;

@Repository
public interface HospitalMapper {
    public int insertHospital(Hospital hospital);
    public List<Hospital> selectHospital(Map<String, Object> params);
    public int updateHospital(Hospital hospital);
    public int deleteHospital(Integer id);
    public Hospital selectHospitalWhereKey(Map<String, Object> params);
    public void clientRefreshHospital(Map<String, Object> params);
    public List<Floor> selectByFloor(Map<String, Object> params);
    public int selectCount();
}
