package com.elabel.hospital.dao.esl;

import com.elabel.hospital.pojo.esl.Esl;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EslMapper {
    public int insertEsl(Esl esl);
    public List<Esl> selectEsl(Map<String,Object> params);
    public int updateEsl(Esl esl);
    public int deleteEsl(Integer id);
    public int deleteEsls(List<Esl> list);
    public List<Esl> selectUpdatedLabels(Map<String, Object> params);
    public int selectCount();
    public void updateEslTime(Map<String, Object> params);
    public int updateList(List<Esl> list);
    public List<Esl> selectEslToBeDeleted(Map<String, Object> params);
}
