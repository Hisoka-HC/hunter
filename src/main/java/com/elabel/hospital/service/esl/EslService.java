package com.elabel.hospital.service.esl;

import com.elabel.hospital.pojo.esl.Esl;

import java.util.List;

public interface EslService {
    public void insertEsl(Esl esl);
    public List<Esl> selectEsl(String order, Integer limit, Integer offset);
    public void updateEsl(Esl esl);
    public void deleteEsl(Integer id);
    public String deleteEsls(List<Esl> list);
    public String updateList(List<Esl> esl);
    public int selectCount();
    public List<Esl> selectEslToBeDeleted(Integer hospitalId, List<Esl> list);
}
