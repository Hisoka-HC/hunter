package com.elabel.hospital.controller.staff;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elabel.hospital.pojo.staff.Position;
import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.staff.PositionService;
import com.elabel.hospital.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PositionController {
    @Resource
    PositionService positionService;

    @RequestMapping(value = "position/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertPosition(HttpSession session,Position position){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        positionService.insertPosition(position);
        return "success";
    }

    @RequestMapping(value = "position/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectPosition(HttpSession session,String order, Integer limit, Integer offset){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Position> position = positionService.selectPosition(order,limit,offset);
        JSONObject result = new JSONObject();
        result.put("rows", JSON.toJSON(position));
        result.put("total", positionService.selectCount());
        return result.toJSONString();
    }

    @RequestMapping(value = "position/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updatePosition(HttpSession session,Position position){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        positionService.updatePosition(position);
        return "success";
    }

    @RequestMapping(value = "position/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deletePosition(HttpSession session,Integer id){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        positionService.deletePosition(id);
        return "success";
    }

}
