package com.elabel.hospital.controller.basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elabel.hospital.pojo.basic.Room;
import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.basic.RoomService;
import com.elabel.hospital.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RoomController {
    @Resource
    RoomService roomService;

    @RequestMapping(value = "room/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertRoom(HttpSession session, Room room) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        room.hospitalId = user.hospitalId;
        roomService.insert(room);
        return "success";
    }

    @RequestMapping(value = "room/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectRoom(HttpSession session, Integer floorId, Integer offset, Integer limit,Integer departmentId) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Room> roomList = roomService.select(floorId, limit, offset,departmentId);
        JSONObject result = new JSONObject();
        result.put("rows", roomList);
        result.put("total", roomService.selectCount(floorId));
        return result.toJSONString();
    }

    @RequestMapping(value = "room/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateRoom(HttpSession session, Room room) {
        User user = GetUserSession.getSessionUser(session);
        if (user == null) {
            return "failed";
        }
        roomService.updateRoom(room);
        return "success";
    }

    @RequestMapping(value = "room/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteRoom(HttpSession session, Integer id) {
        User user = GetUserSession.getSessionUser(session);
        if (user == null) {
            return "failed";
        }
        roomService.deleteRoom(id);
        return "success";
    }
}
