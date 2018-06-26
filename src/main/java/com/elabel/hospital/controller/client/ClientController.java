package com.elabel.hospital.controller.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.elabel.hospital.pojo.basic.Department;
import com.elabel.hospital.pojo.basic.Floor;
import com.elabel.hospital.pojo.basic.Hospital;
import com.elabel.hospital.pojo.esl.Esl;
import com.elabel.hospital.pojo.patient.Patient;
import com.elabel.hospital.service.basic.DepartmentService;
import com.elabel.hospital.service.basic.HospitalService;
import com.elabel.hospital.service.client.ClientService;
import com.elabel.hospital.service.esl.EslService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientController {

    @Resource
    HospitalService hospitalService;

    @Resource
    EslService eslService;

    @Resource
    ClientService clientService;

    /**
     * 传递一个医院名字 查询所有被修改过的数据  然后restore数据状态回Normal
     * @return
     */
    @RequestMapping(value = "client/select.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String clientFetchData(Integer key,String order) {
        Hospital hospital = hospitalService.selectHospitalWhereKey(key,order);
        if (hospital == null) {
            return "failed";
        }
        Timestamp lastLoginTime = hospital.clientLoginTime;


        Integer hospitalId = hospital.id;
        clientService.clientRefreshHospital(key);
        JSONObject data = new JSONObject();
        List<Patient> goodsUpdated = clientService.selectPatient(hospitalId, "updated", order);
        List<Patient> goodsDeleted = new ArrayList<>();

        JSONObject goodsObj = new JSONObject();
        goodsObj.put("inserted",JSONArray.toJSON(new ArrayList<>()));
        goodsObj.put("updated", JSONArray.toJSON(goodsUpdated));
        goodsObj.put("deleted", goodsDeleted);
        data.put("goods", goodsObj);

        JSONObject eslObj = new JSONObject();
       // clientService.updateEslTime(hospitalId);
        List<Esl> eslUpdated = clientService.selectUpdatedLabels(hospitalId, lastLoginTime, order);
        List<Esl> eslDeleted = new ArrayList<>();

        eslObj.put("updated", JSONArray.toJSON(eslUpdated));
        eslObj.put("deleted", eslDeleted);
        data.put("label", eslObj);

        clientService.restoreNormal(hospitalId);

        return data.toJSONString();
    }

    /**
     * 按需求查找
     *
     * @return
     */
    @RequestMapping(value = "client/selectByRequirement.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectByDepartment(String floorName, String departmentName, String roomName, String bedName, String patientName, String patientGender, Integer patientAge, String diseaseName, String keyword, String firstKeyword) {
        List departments = clientService.selectByRequeirtment(floorName, departmentName, roomName, bedName, patientName, patientGender, patientAge, diseaseName, keyword, firstKeyword);
        JSONArray array = (JSONArray) JSONArray.toJSON(departments);
        return array.toJSONString();
    }

    @RequestMapping(value = "client/restoreNormal.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String selectPatientStatus(Integer hospitalId) {
        List list = clientService.selectPatientStatusIsUpdated();
        if (list != null) {
            clientService.restoreNormal(hospitalId);
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "client/validate.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String clientValidate(Integer key,String order) {
        Hospital hospital = hospitalService.selectHospitalWhereKey(key, order);
        if (hospital == null)
            return "failed";
        else
            return "success";
    }


    @RequestMapping(value = "client/esl/update.do", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String receiveLabelsInsertInfo(HttpSession httpSession, @RequestBody String buff, String order) throws IOException {
        String jsonStr = URLDecoder.decode(buff, "utf8").replaceAll("=", "");
        JSONObject obj = JSON.parseObject(jsonStr);
        Integer key = obj.getInteger("key");
        Hospital hospital = hospitalService.selectHospitalWhereKey(key,order);
        if (hospital == null)
            return "{}";
        Integer hospitalId = hospital.id;
        JSONArray insertedJson = (JSONArray) obj.get("inserted");
        List<Esl> inserted = JSON.parseArray(insertedJson.toJSONString(), Esl.class);
        List<Esl> deleteList = eslService.selectEslToBeDeleted(hospitalId, inserted);//之前插入到其他门店的标签ID集合
        if (deleteList.size() > 0)
            eslService.deleteEsls(deleteList);//删除插入到其他门店的标签ID
        for (Esl esl : inserted) {
            esl.hospitalId = hospitalId;
        }
        eslService.updateList(inserted);
        return "success";

    }

}
