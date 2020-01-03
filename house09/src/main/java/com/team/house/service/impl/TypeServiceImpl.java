package com.team.house.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.mapper.TypeMapper;
import com.team.house.service.TypeService;
import com.team.until.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
   private TypeMapper typeMapper;

    @Override
    public PageInfo<Type> getTypeByPage(PageUtil pageUtil) {
        //开启分页
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        //查询
        TypeExample typeExample = new TypeExample();
        List<Type> list = typeMapper.selectByExample(typeExample);

        return new PageInfo<>(list);
    }

    @Override
    public Integer addType(Type type) {
        return typeMapper.insertSelective(type);

    }

    @Override
    public Integer updateType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public Type getType(Integer id) {
        return typeMapper.selectByPrimaryKey(id);

    }

    @Override
    public Integer deleteType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Integer deleteMoreType(Integer[] ids) {
            return typeMapper.deleteMoreType(ids);

    }

    @Override
    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());

    }
}
