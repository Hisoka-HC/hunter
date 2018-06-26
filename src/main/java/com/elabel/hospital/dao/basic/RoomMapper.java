package com.elabel.hospital.dao.basic;

import com.elabel.hospital.pojo.basic.Room;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoomMapper {
    public int insertRoom(Room room);

    public List<Room> selectRoom(Map<String, Object> params);

    public int selectCount(Map<String, Object> params);

    public int updateRoom(Room room);

    public int deleteRoom(Integer id);
}
