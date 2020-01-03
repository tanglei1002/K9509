package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.until.UserCondition;

/**
 * @author 王建兵
 * @Classname DistritctService
 * @Description TODO
 * @Date 2019/12/20 16:42
 * @Created by Administrator
 */
public interface UserService {
     /**
      * 查询区域带分页
      * @param condition
      *   包含查询的条件
      *   page属性接收页码，rows接收页大小
      * @return
      */
     public PageInfo<Users> getUserByPage(UserCondition condition);
     //检查用户是否存在
     public boolean checkUname(String name);
     //注册用户
     public Integer addUser(Users users);
     //用户登录
     public Users login(String username,String password);

}
