package com.elabel.hospital.dao.basic;

import com.elabel.hospital.pojo.basic.Bed;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface BedMapper {
    public int insertBed(Bed bed);

    public List<Bed> selectBed(Map<String, Object> params);

    public int selectCount(Map<String, Object> params);

    public int updateBed(Bed bed);

    public int deleteBed(Integer id);
}
