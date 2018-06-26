package com.elabel.hospital.service.esl;

import com.elabel.hospital.dao.esl.EslMapper;
import com.elabel.hospital.pojo.esl.Esl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("eslService")
public class EslServiceImpl implements EslService {

    @Resource
    EslMapper eslMapper;


    @Override
    public void insertEsl(Esl esl) {
        eslMapper.insertEsl(esl);
    }

    @Override
    public List<Esl> selectEsl(String order, Integer limit, Integer offset) {
        Map params = new HashMap();
        params.put("order",order);
        params.put("limit",limit);
        params.put("offset",offset);
        return eslMapper.selectEsl(params);
    }

    @Override
    public void updateEsl(Esl esl) {
        eslMapper.updateEsl(esl);
    }

    @Override
    public void deleteEsl(Integer id) {
        eslMapper.deleteEsl(id);
    }

    @Override
    public String deleteEsls(List<Esl> list) {
        int rows = eslMapper.deleteEsls(list);
        if(rows>0){
            return "success";
        }
        return "failed";
    }

    @Override
    public String updateList(List<Esl> esl) {
        int rows = eslMapper.updateList(esl);
        if (rows>0){
            return "success";
        }
        return "failed";
    }

    @Override
    public int selectCount() {
        return eslMapper.selectCount();
    }

    @Override
    public List<Esl> selectEslToBeDeleted(Integer hospitalId, List<Esl> list) {
        Map params = new HashMap();
        params.put("hospitalId",hospitalId);
        params.put("list",list);
        return eslMapper.selectEslToBeDeleted(params);
    }
}
