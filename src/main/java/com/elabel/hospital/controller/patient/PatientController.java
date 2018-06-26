package com.elabel.hospital.controller.patient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.elabel.hospital.dao.patient.PatientMapper;
import com.elabel.hospital.pojo.patient.Patient;
import com.elabel.hospital.pojo.user.User;
import com.elabel.hospital.service.client.ClientService;
import com.elabel.hospital.service.patient.PatientService;
import com.elabel.hospital.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PatientController {
    @Resource
    PatientService patientService;

    @Resource
    PatientMapper patientMapper;


    @Resource
    ClientService clientService;

    @RequestMapping(value = "patient/insert.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String insertPatient(HttpSession session, Patient patient) {
        User user = GetUserSession.getSessionUser(session);
        if (user == null) {
            return "failed";
        }
        patient.hospitalId = user.hospitalId;
        patientService.insertPatient(patient);
        return "success";
    }

    @RequestMapping(value = "patient/selectPatientStatusIsUpdated.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectPatientStatusIsUpdated(HttpSession session) {
        User user = GetUserSession.getSessionUser(session);
        if (user == null) {
            return "failed";
        }
        List list = clientService.selectPatientStatusIsUpdated();
        JSONArray array = (JSONArray) JSONArray.toJSON(list);
        return array.toJSONString();
    }

    @RequestMapping(value = "patient/select.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectPatient(HttpSession session,Integer departmentId, String order, Integer bedId, Integer limit, Integer offset) {
        User user = GetUserSession.getSessionUser(session);
        if (user == null) {
            return "failed";
        }
        List<Patient> patient = patientService.selectPatient(departmentId,bedId, order, limit, offset);
        JSONObject result = new JSONObject();
        result.put("rows", JSON.toJSON(patient));
        result.put("total", patientService.selectCount());
        return result.toJSONString();
    }

    @RequestMapping(value = "patient/update.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String updatePatient(HttpSession session, Patient patient) {
        User user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        patientService.updatePatient(patient);
        return "success";
    }

    @RequestMapping(value = "patient/delete.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deletePatient(HttpSession session, Integer id) {
        User user = GetUserSession.getSessionUser(session);
        if (user == null) {
            return "failed";
        }
        patientService.deletePatient(id);
        return "success";
    }

    @RequestMapping(value = "patient/selectByStatus.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectByStatus(HttpSession session,String status) {
        User user = GetUserSession.getSessionUser(session);
        if (user == null) {
            return "failed";
        }
        List<Patient> patientList = patientService.selectByStatus(status);
        JSONArray array = (JSONArray) JSONArray.toJSON(patientList);
        return array.toJSONString();
    }

    /**
     * @author Ding.
     */
    @RequestMapping(value = "patient/makeBed.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String makeBed(Integer bedId) {
        Map<String, Object> params = new HashMap<>();
        params.put("bedId", bedId);
        patientMapper.makeBed(params);

        return "success";
    }


}
