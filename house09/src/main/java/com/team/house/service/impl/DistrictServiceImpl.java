package com.team.house.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.service.DistrictService;
import com.team.until.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
   private DistrictMapper districtMapper;
    @Override
    public PageInfo<District> getDistrictByPage(PageUtil pageUtil) {
        //开启分页
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        //查询
        DistrictExample districtExample = new DistrictExample();
        List<District> list = districtMapper.selectByExample(districtExample);

        return new PageInfo<>(list);
    }

    @Override
    public Integer addDistrict(District district) {
        return districtMapper.insertSelective(district);

    }

    @Override
    public Integer updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    @Override
    public District getDistrict(Integer id) {
        return districtMapper.selectByPrimaryKey(id);

    }

    @Override
    public Integer deleteDistrict(Integer id) {
        return districtMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Integer deleteMoreDistrict(Integer[] ids) {
            return districtMapper.deleteMoreDistrict(ids);

    }

    @Override
    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }


}
