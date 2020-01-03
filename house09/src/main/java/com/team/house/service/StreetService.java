package com.team.house.service;

import com.team.house.entity.Street;

import java.util.List;

public interface StreetService {

    //查询对应区域下的街道
    public List<Street> getStreetByDistrict(Integer did);
}

