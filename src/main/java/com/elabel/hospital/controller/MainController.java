package com.elabel.hospital.controller;

import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @Resource
    UserService userService;

    @RequestMapping(value = {"main", "/", ""}, method = RequestMethod.GET)
    public String main(HttpSession httpSession) {
        return "views/login.jsp";
    }

    @RequestMapping(value = "hospital/login.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String login(User user, HttpSession session){
        User userInfo = userService.login(user);
        if(userInfo!=null){
            session.setAttribute("user",userInfo);
            return "success";
        }
        return "default";
    }

    @RequestMapping(value = "hospital/logout.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String logout(HttpSession session){
        session.setAttribute("user",null);
        return "";
    }


}
