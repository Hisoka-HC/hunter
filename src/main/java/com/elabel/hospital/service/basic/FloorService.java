package com.elabel.hospital.service.basic;

import com.elabel.hospital.dao.basic.FloorMapper;
import com.elabel.hospital.pojo.basic.Floor;

import java.util.List;

public interface FloorService {
    public void insert(Floor floor);

    public List<Floor> select(Integer limit, Integer offset);

    public int selectCount();

    public void update(Floor floor);

    public void delete(int id);
}
