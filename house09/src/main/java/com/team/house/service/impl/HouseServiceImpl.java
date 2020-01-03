package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.mapper.HouseMapper;
import com.team.house.service.HouseService;
import com.team.until.PageUtil;
import com.team.until.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
@Autowired
private HouseMapper houseMapper;

    @Override
    public Integer addHouse(House house) {
        return  houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByUser(Integer id, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        List<House> list = houseMapper.getHouseByUser(id);
        return new PageInfo<House>(list);
    }

    @Override
    public House getHouse(String id) {
        return houseMapper.getHouse(id);
    }

    @Override
    public Integer deleteHouse(String houseId, Integer delState) {
       House house = new House();
       house.setId(houseId);
       house.setIsdel(delState);
       return houseMapper.updateByPrimaryKeySelective(house);

    }

    @Override
    public PageInfo<House> getBackAllHouse(PageUtil pageUtil) {
       List<House> list= PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        return new PageInfo<House>(list);
    }

    @Override
    public Integer passHouse(String houseId, Integer passState) {
        House house=new House();
        house.setId(houseId);  //条件
        house.setIspass(passState);  //更新审核状态
        return houseMapper.updateByPrimaryKeySelective(house);

    }

      @Override
    public PageInfo<House> getBroswerHouse(SearchCondition searchCondition) {
        PageHelper.startPage(searchCondition.getPage(),searchCondition.getRows());
        List<House> list=houseMapper.getBroswerHouse(searchCondition);
        return new PageInfo<>(list);
    }
}
