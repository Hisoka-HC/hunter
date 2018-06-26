package com.elabel.hospital.controller.disease;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.elabel.hospital.pojo.disease.Disease;
import com.elabel.hospital.pojo.disease.DiseaseCategory;
import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.disease.DiseaseService;
import com.elabel.hospital.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DiseaseController {
    @Resource
    DiseaseService diseaseService;

    @RequestMapping(value = "disease/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertDisease(HttpSession session,Disease disease){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        diseaseService.insertDisease(disease);
        return "success";
    }

    @RequestMapping(value = "disease/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectDisease(HttpSession session,String order, Integer limit, Integer offset){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Disease> disease = diseaseService.selectDisease(order,limit,offset);
        JSONObject result = new JSONObject();
        result.put("rows", JSON.toJSON(disease));
        result.put("total", diseaseService.selectCount());
        return result.toJSONString();
    }

    @RequestMapping(value = "diseaseCategory/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertDiseaseCategory(HttpSession session,DiseaseCategory diseaseCategory){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        diseaseService.insertDiseaseCategory(diseaseCategory);
        return "success";
    }

    @RequestMapping(value = "diseaseCategory/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectDiseaseCategory(HttpSession session,String order, Integer limit, Integer offset){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<DiseaseCategory> diseaseCategory = diseaseService.selectDiseaseCategory(order,limit,offset);
        JSONObject result = new JSONObject();
        result.put("rows", JSON.toJSON(diseaseCategory));
        result.put("total", diseaseService.selectCountCategory());
        return result.toJSONString();
    }

    @RequestMapping(value = "disease/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateDisease(HttpSession session,Disease disease){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        diseaseService.updateDisease(disease);
        return "success";
    }

    @RequestMapping(value = "diseaseCategory/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateDiseaseCategory(HttpSession session,DiseaseCategory diseaseCategory){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        diseaseService.updateDiseaseCategory(diseaseCategory);
        return "success";
    }

    @RequestMapping(value = "disease/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteDisease(HttpSession session,Integer id){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        diseaseService.deleteDisease(id);
        return "success";
    }

    @RequestMapping(value = "diseaseCategory/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String daleteDiseaseCategory(HttpSession session,Integer id){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        diseaseService.deleteDiseaseCategory(id);
        return "success";
    }

}
