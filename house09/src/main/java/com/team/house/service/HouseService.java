package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.until.PageUtil;
import com.team.until.SearchCondition;

public interface HouseService {
    public Integer addHouse(House house);

    public PageInfo<House> getHouseByUser(Integer id, PageUtil pageUtil);

    public House getHouse(String id);

    public Integer deleteHouse(String houseId,Integer delState);

    public PageInfo<House> getBackAllHouse(PageUtil pageUtil);

    public Integer passHouse(String houseId,Integer passState);

    public PageInfo<House> getBroswerHouse(SearchCondition searchCondition);

}
