package com.team.house.service;


import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.until.PageUtil;

import java.util.List;

public interface TypeService {
    /*
    * 查询区域带分页
    * */
    public PageInfo<Type> getTypeByPage(PageUtil pageUtil);

    //添加区域
    public Integer addType(Type Type);
    //修改
    public Integer updateType(Type Type);
    //
    public Type getType(Integer id);
    //删除区域
    public Integer deleteType(Integer id);

    /*实现区域批量删除*/
    public Integer deleteMoreType(Integer[] ids);
    //查询所有类型
    public List<Type> getAllType();


}
