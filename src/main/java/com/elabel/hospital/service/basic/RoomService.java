package com.elabel.hospital.service.basic;

import com.elabel.hospital.pojo.basic.Room;

import java.util.List;

public interface RoomService {
    public void insert(Room room);

    public List<Room> select(Integer floorId, Integer limit, Integer offset,Integer departmentId);

    public int selectCount(Integer floorId);

    public void updateRoom(Room room);

    public void deleteRoom(Integer id);
}
