package com.elabel.hospital.service.basic;

import com.elabel.hospital.dao.basic.RoomMapper;
import com.elabel.hospital.pojo.basic.Room;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Resource
    RoomMapper roomMapper;

    @Override
    public void insert(Room room) {
        roomMapper.insertRoom(room);
    }

    @Override
    public List<Room> select(Integer floorId, Integer limit, Integer offset,Integer departmentId) {
        Map params = new HashMap();
        params.put("floorId", floorId);
        params.put("limit", limit);
        params.put("offset", offset);
        params.put("departmentId",departmentId);
        return roomMapper.selectRoom(params);
    }

    public int selectCount(Integer floorId) {
        Map params = new HashMap();
        params.put("floorId", floorId);
        return roomMapper.selectCount(params);
    }


    @Override
    public void updateRoom(Room room) {
        roomMapper.updateRoom(room);
    }

    @Override
    public void deleteRoom(Integer id) {
        roomMapper.deleteRoom(id);
    }
}
