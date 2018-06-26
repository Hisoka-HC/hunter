package com.elabel.hospital.controller.basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elabel.hospital.pojo.basic.Bed;
import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.basic.BedService;
import com.elabel.hospital.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BedController {
    @Resource
    BedService bedService;

    @RequestMapping(value = "bed/insert.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertBed(HttpSession session, Bed bed) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        bed.hospitalId=user.hospitalId;
        bedService.insertBed(bed);
        return "success";
    }

    @RequestMapping(value = "bed/select.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectBed(HttpSession session, Integer roomId, Integer floorId, Integer limit, Integer offset) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Bed> bedList = bedService.selectBed(floorId, roomId, limit, offset);
        JSONObject result = new JSONObject();
        result.put("rows", JSON.toJSON(bedList));
        result.put("total", bedService.selectCount(floorId, roomId));
        return result.toJSONString();
    }

    @RequestMapping(value = "bed/update.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateBed(HttpSession session, Bed bed) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        bedService.updateBed(bed);
        return "success";
    }

    @RequestMapping(value = "bed/delete.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteBed(HttpSession session, Integer id) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        bedService.deleteBed(id);
        return "success";
    }

}
