package com.elabel.hospital.dao.basic;

import com.elabel.hospital.pojo.basic.Floor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FloorMapper {
    public int insertFloor(Floor floor);

    public List<Floor> selectFloor(Map<String, Object> params);

    public int selectCount(Map<String, Object> params);

    public int updateFloor(Floor floor);

    public int deleteFloor(Integer id);

    public Floor selectAll();

}
