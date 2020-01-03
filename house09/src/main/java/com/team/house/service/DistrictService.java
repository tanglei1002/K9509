package com.team.house.service;


import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.until.PageUtil;

import java.util.List;

public interface DistrictService {
    /*
    * 查询区域带分页
    * */
    public PageInfo<District> getDistrictByPage(PageUtil pageUtil);

    //添加区域
    public Integer addDistrict(District district);
    //修改
    public Integer updateDistrict(District district);
    //
    public District getDistrict(Integer id);
    //删除区域
    public Integer deleteDistrict(Integer id);

    /*实现区域批量删除*/
    public Integer deleteMoreDistrict(Integer[] ids);
    //查询所有区域
    List<District> getAllDistrict();


}
