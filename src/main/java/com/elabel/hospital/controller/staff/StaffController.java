package com.elabel.hospital.controller.staff;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elabel.hospital.pojo.staff.Staff;
import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.staff.StaffService;
import com.elabel.hospital.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StaffController {
    @Resource
    StaffService staffService;

    @RequestMapping(value = "staff/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertStaff(HttpSession session,Staff staff){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        staffService.insertStaff(staff);
        return "success";
    }

    @RequestMapping(value = "staff/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectStaff(HttpSession session,String order, Integer limit, Integer offset){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Staff> staff = staffService.selectStaff(order,limit,offset);
        JSONObject result = new JSONObject();
        result.put("rows", JSON.toJSON(staff));
        result.put("total", staffService.selectCount());
        return result.toJSONString();
    }

    @RequestMapping(value = "staff/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateStaff(HttpSession session,Staff staff){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        staffService.updateStaff(staff);
        return "success";
    }

    @RequestMapping(value = "staff/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteStaff(HttpSession session,Integer id){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        staffService.deleteStaff(id);
        return "success";
    }
}
