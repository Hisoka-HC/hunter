package com.elabel.hospital.service.staff;

import com.elabel.hospital.dao.staff.PositionMapper;
import com.elabel.hospital.pojo.staff.Position;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("positionService")
public class PositionServiceImpl implements PositionService {

    @Resource
    PositionMapper positionMapper;

    @Override
    public void insertPosition(Position position) {
        positionMapper.insertPosition(position);
    }

    @Override
    public List<Position> selectPosition(String order, Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("order",order);
        params.put("limit",limit);
        params.put("offset",offset);
        return positionMapper.selectPosition(params);
    }

    @Override
    public void updatePosition(Position position) {
        positionMapper.updatePosition(position);
    }

    @Override
    public void deletePosition(Integer id) {
        positionMapper.deletePosition(id);
    }

    @Override
    public int selectCount() {
        return positionMapper.selectCount();
    }
}
