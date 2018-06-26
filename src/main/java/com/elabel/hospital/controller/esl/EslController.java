package com.elabel.hospital.controller.esl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elabel.hospital.pojo.esl.Esl;
import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.esl.EslService;
import com.elabel.hospital.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EslController {
    @Resource
    EslService eslService;

    @RequestMapping(value = "esl/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertEsl(HttpSession session,Esl esl){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        esl.hospitalId = user.hospitalId;
        eslService.insertEsl(esl);
        return "success";
    }

    @RequestMapping(value = "esl/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectEsl(HttpSession session,String order, Integer limit, Integer offset){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Esl> esl = eslService.selectEsl(order,limit,offset);
        JSONObject result = new JSONObject();
        result.put("rows", JSON.toJSON(esl));
        result.put("total", eslService.selectCount());
        return result.toJSONString();
    }

    @RequestMapping(value = "esl/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateEsl(HttpSession session,Esl esl){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        eslService.updateEsl(esl);
        return "success";
    }

    @RequestMapping(value = "esl/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteEsl(HttpSession session,Integer id){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        eslService.deleteEsl(id);
        return "success";
    }

}
