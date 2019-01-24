package com.sh.vehiclemanagement.demo.service.impl;

import com.sh.vehiclemanagement.demo.dao.VehicleMapper;
import com.sh.vehiclemanagement.demo.entity.VehicleEntity;
import com.sh.vehiclemanagement.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleMapper vehicleMapper;


    @Override
    public int deleteByID(Integer id) {
        return vehicleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(VehicleEntity record) {
        return vehicleMapper.insert(record);
    }

    @Override
    public int insertSelective(VehicleEntity record) {
        return vehicleMapper.insertSelective(record);
    }

    @Override
    public VehicleEntity selectByID(Integer id) {
        return vehicleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateSelective(VehicleEntity record) {
        return vehicleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int update(VehicleEntity record) {
        return vehicleMapper.updateByPrimaryKey(record);
    }

}
