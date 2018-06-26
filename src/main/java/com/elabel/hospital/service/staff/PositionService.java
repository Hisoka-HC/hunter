package com.elabel.hospital.service.staff;

import com.elabel.hospital.pojo.staff.Position;

import java.util.List;

public interface PositionService {
    public void insertPosition(Position position);
    public List<Position> selectPosition(String order, Integer limit, Integer offset);
    public void updatePosition(Position position);
    public void deletePosition(Integer id);
    public int selectCount();
}
