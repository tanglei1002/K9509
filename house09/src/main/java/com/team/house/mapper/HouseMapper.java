package com.team.house.mapper;

import com.team.house.entity.House;
import com.team.house.entity.HouseExample;
import com.team.until.SearchCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
    //
    List<House> getHouseByUser(Integer userid);
    //
    House getHouse(String id);
    //
    List<House> getBackAllHouse();
    //
    List<House> getBroswerHouse(SearchCondition searchCondition);
}