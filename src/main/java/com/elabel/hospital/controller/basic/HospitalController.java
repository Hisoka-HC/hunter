package com.elabel.hospital.controller.basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elabel.hospital.pojo.basic.Hospital;
import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.basic.HospitalService;
import com.elabel.hospital.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HospitalController {

    @Resource
    HospitalService hospitalService;

    @RequestMapping(value = "hospital/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertHospital(HttpSession session, Hospital hospital) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        hospitalService.insertHospital(hospital);
        return "success";
    }

    @RequestMapping(value = "hospital/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectHospital(HttpSession session, String order, Integer limit, Integer offset) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Hospital> hospital = hospitalService.selectHospital(order,limit,offset);
        JSONObject result = new JSONObject();
        result.put("rows", JSON.toJSON(hospital));
        result.put("total", hospitalService.selectCount());
        return result.toJSONString();
    }

    @RequestMapping(value = "hospital/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateHospital(HttpSession session, Hospital hospital) {
        User user = GetUserSession.getSessionUser(session);
        if (user == null) {
            return "failed";
        }
        hospitalService.updateHospital(hospital);
        return "success";
    }

    @RequestMapping(value = "hospital/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteHospital(HttpSession session, Integer id) {
        User user = GetUserSession.getSessionUser(session);
        if (user == null) {
            return "failed";
        }
        hospitalService.deleteHospital(id);
        return "success";
    }


}
