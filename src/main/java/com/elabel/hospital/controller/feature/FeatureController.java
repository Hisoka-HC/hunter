package com.elabel.hospital.controller.feature;

import com.alibaba.fastjson.JSONArray;
import com.elabel.hospital.pojo.feature.Allergy;
import com.elabel.hospital.pojo.feature.Eating;
import com.elabel.hospital.pojo.feature.NursingLevel;
import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.feature.FeatureService;
import com.elabel.hospital.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FeatureController {

    @Resource
    FeatureService featureService;

    @RequestMapping(value = "allergy/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertAllergy(HttpSession session,Allergy allergy){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        featureService.insertAllergy(allergy);
        return "success";
    }

    @RequestMapping(value = "eating/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertEating(HttpSession session,Eating eating){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        featureService.insertEating(eating);
        return "success";
    }

    @RequestMapping(value = "nursingLevel/insert.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertNursingLevel(HttpSession session,NursingLevel nursingLevel){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        featureService.insertNursingLevel(nursingLevel);
        return "success";
    }

    @RequestMapping(value = "nursingLevel/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectNursingLevel(HttpSession session){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<NursingLevel> nursingLevellist = featureService.selectNursingLevel();
        JSONArray array = (JSONArray) JSONArray.toJSON(nursingLevellist);
        return array.toJSONString();
    }

    @RequestMapping(value = "eating/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectEating(HttpSession session){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Eating> eatinglist = featureService.selectEating();
        JSONArray array = (JSONArray) JSONArray.toJSON(eatinglist);
        return array.toJSONString();
    }

    @RequestMapping(value = "allergy/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectAllergy(HttpSession session){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Allergy> featurelist = featureService.selectAllergy();
        JSONArray array = (JSONArray) JSONArray.toJSON(featurelist);
        return array.toJSONString();
    }

    @RequestMapping(value = "allergy/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateAllergy(HttpSession session,Allergy allergy){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        featureService.updateAllergy(allergy);
        return "success";
    }

    @RequestMapping(value = "eating/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateEating(HttpSession session,Eating eating){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        featureService.updateEating(eating);
        return "success";
    }

    @RequestMapping(value = "nursingLevel/update.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updateNursingLevel(HttpSession session,NursingLevel nursingLevel){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        featureService.updateNursingLevel(nursingLevel);
        return "success";
    }

    @RequestMapping(value = "allergy/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteAllergy(HttpSession session,Allergy allergy){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        featureService.deleteAllergy(allergy);
        return "success";
    }

    @RequestMapping(value = "eating/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteEating(HttpSession session,Eating eating){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        featureService.deleteEating(eating);
        return "success";
    }

    @RequestMapping(value = "nursingLevel/delete.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteNursingLevel(HttpSession session,NursingLevel nursingLevel){
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        featureService.deleteNursingLevel(nursingLevel);
        return "success";
    }


}
