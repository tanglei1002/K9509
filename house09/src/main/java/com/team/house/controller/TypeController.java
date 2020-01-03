package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.service.TypeService;
import com.team.until.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class TypeController {
    @Autowired
    private TypeService TypeService;
    @RequestMapping("getTypeData")
    public Map<String,Object> getTypeData(PageUtil pageUtil){
        PageInfo<Type> pageInfo = TypeService.getTypeByPage(pageUtil);
    Map<String,Object> map = new HashMap<>();
    map.put("total",pageInfo.getTotal());
    map.put("rows",pageInfo.getList());
    return map;

    }

    //添加
    @RequestMapping("addType")
    public String addType(Type Type){
        try {
            //调用业务
            int result=TypeService.addType(Type);
            //封装返回数据
            // Map<String,Object> map=new HashMap<>();   //自动转json
            // map.put("result",result);
            return "{\"result\":"+result+"}";   //拼接的json
        }catch (Exception e){
            return "{\"result\":-1}";
        }
    }

        //修改区域
        @RequestMapping("updateType")
        public String updateType(Type Type){
            try {
                //调用业务
                Integer result=TypeService.updateType(Type);
                //封装返回数据
                // Map<String,Object> map=new HashMap<>();   //自动转json
                // map.put("result",result);
                return "{\"result\":"+result+"}";   //拼接的json
            }catch (Exception e){
                return "{\"result\":-1}";
            }
        }


    //获取单条数据
    @RequestMapping("getType")
    public Type grtType(Integer id) {
        try {
            return TypeService.getType(id);
        }catch (Exception e){

        }
        return null;
    }

    //删除
    @RequestMapping("delType")
    public String delType(Integer id){
        try {
            Integer result = TypeService.deleteType(id);
            return "{\"result\":"+result+"}";
        }catch (Exception e){
            return "{\"result\":-1}";
        }
    }

    //批量删除区域
    //前台传递数据的格式:ids=1,2,3,4     后台: String ids变量接收数据
    //前台传递数据的格式:ids=1&ids=2&ids=3     后台: Integer []ids变量接收数据
    @RequestMapping("delMoreType")
    public String delMoreType(String ids){
        try {
            String[] strList = ids.split(",");
            Integer[] idList=new Integer[strList.length];
            for (int i=0;i<strList.length;i++){
                idList[i]=new Integer(strList[i]);
            }
            //调用业务
            Integer temp = TypeService.deleteMoreType(idList);
            return "{\"result\":"+temp+"}";   //拼接的json
        }catch (Exception e){
            e.printStackTrace();   //使用日志工具记录
            return "{\"result\":-1}";
        }
        }
    }


