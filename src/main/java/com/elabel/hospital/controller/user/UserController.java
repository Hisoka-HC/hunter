package com.elabel.hospital.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.user.UserService;
import com.elabel.hospital.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "user/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String inserUser(HttpSession session,User user){
        User user_info = GetUserSession.getSessionUser(session);
        if (user_info==null){
            return "failed";
        }
        userService.insertUser(user);
        return "success";
    }

    @RequestMapping(value = "user/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectUser(HttpSession session,String order, Integer limit, Integer offset){
        User user_info = GetUserSession.getSessionUser(session);
        if (user_info==null){
            return "failed";
        }
        List<User> user = userService.selectUser(order,limit,offset);
        JSONObject result = new JSONObject();
        result.put("rows", JSON.toJSON(user));
        result.put("total", userService.selectCount());
        return result.toJSONString();
    }

    @RequestMapping(value = "user/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateUser(HttpSession session,User user){
        User user_info = GetUserSession.getSessionUser(session);
        if (user_info==null){
            return "failed";
        }
        userService.updateUser(user);
        return "success";
    }

    @RequestMapping(value = "user/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteUser(HttpSession session,Integer id){
        User user_info = GetUserSession.getSessionUser(session);
        if (user_info==null){
            return "failed";
        }
        userService.deleteUser(id);
        return "success";
    }

}
