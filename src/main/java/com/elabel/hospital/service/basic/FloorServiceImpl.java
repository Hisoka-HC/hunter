package com.elabel.hospital.service.basic;

import com.elabel.hospital.dao.basic.FloorMapper;
import com.elabel.hospital.pojo.basic.Floor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("floorService")
public class FloorServiceImpl implements FloorService {
    @Resource
    FloorMapper floorMapper;

    @Override
    public void insert(Floor floor) {
        floorMapper.insertFloor(floor);
    }

    @Override
    public List<Floor> select(Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("limit", limit);
        params.put("offset", offset);
        return floorMapper.selectFloor(params);
    }




    @Override
    public int selectCount() {
        Map params = new HashMap();
        return floorMapper.selectCount(params);
    }

    @Override
    public void update(Floor floor) {
        floorMapper.updateFloor(floor);
    }

    @Override
    public void delete(int id) {
        floorMapper.deleteFloor(id);
    }

}
