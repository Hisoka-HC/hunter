package com.elabel.hospital.controller.basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elabel.hospital.pojo.basic.Floor;
import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.basic.FloorService;
import com.elabel.hospital.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FloorController {
    @Resource
    FloorService floorService;

    @RequestMapping(value = "floor/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertFloor(HttpSession session, Floor floor) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        floor.hospitalId = user.hospitalId;
        floorService.insert(floor);
        return "success";
    }

    @RequestMapping(value = "floor/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectFloor(HttpSession session, Integer limit, Integer offset) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Floor> floorList = floorService.select(limit, offset);
        JSONObject result = new JSONObject();
        result.put("rows", JSON.toJSON(floorList));
        result.put("total", floorService.selectCount());
        return result.toJSONString();
    }

    @RequestMapping(value = "floor/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String update(HttpSession session, Floor floor) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        floorService.update(floor);
        return "success";
    }

    @RequestMapping(value = "floor/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteFloor(HttpSession session, Integer id) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        floorService.delete(id);
        return "success";
    }

}
