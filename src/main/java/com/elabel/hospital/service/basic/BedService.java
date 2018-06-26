package com.elabel.hospital.service.basic;


import com.elabel.hospital.pojo.basic.Bed;
import com.elabel.hospital.pojo.patient.Patient;

import java.util.List;

public interface BedService {
    public void insertBed(Bed bed);

    public List<Bed> selectBed(Integer floorId, Integer roomId, Integer limit, Integer offset);

    public int selectCount(Integer floorId, Integer roomId);

    public void updateBed(Bed bed);

    public void deleteBed(Integer id);
}
