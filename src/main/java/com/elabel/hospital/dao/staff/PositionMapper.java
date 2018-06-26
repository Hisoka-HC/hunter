package com.elabel.hospital.dao.staff;

import com.elabel.hospital.pojo.staff.Position;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PositionMapper {
    public int insertPosition(Position position);
    public List<Position> selectPosition(Map<String ,Object> params);
    public int updatePosition(Position position);
    public int deletePosition(Integer id);
    public int selectCount();
}
