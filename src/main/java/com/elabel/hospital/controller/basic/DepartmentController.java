package com.elabel.hospital.controller.basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elabel.hospital.pojo.basic.Department;
import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.basic.DepartmentService;
import com.elabel.hospital.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DepartmentController {
    @Resource
    DepartmentService departmentService;

    @RequestMapping(value = "department/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertDepartment(HttpSession session,Department department){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        department.hospitalId = user.hospitalId;
        departmentService.insertDepartment(department);
        return "success";
    }

    @RequestMapping(value = "department/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectDepartment(HttpSession session,String order, Integer limit, Integer offset){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Department> department = departmentService.selectDepartment(order,limit,offset);
        JSONObject result = new JSONObject();
        result.put("rows", JSON.toJSON(department));
        result.put("total", departmentService.selectCount());
        return result.toJSONString();
    }

    @RequestMapping(value = "department/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateDepartment(HttpSession session,Department department){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        departmentService.updateDepartment(department);
        return "success";
    }

    @RequestMapping(value = "department/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteDepartment(HttpSession session,Integer id){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        departmentService.deleteDepartment(id);
        return "success";
    }

}
