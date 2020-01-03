package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import com.team.until.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @RequestMapping("getDistrictData")
    public Map<String,Object> getDistrictData(PageUtil pageUtil){
        PageInfo<District> pageInfo = districtService.getDistrictByPage(pageUtil);
    Map<String,Object> map = new HashMap<>();
    map.put("total",pageInfo.getTotal());
    map.put("rows",pageInfo.getList());
    return map;

    }

    //添加
    @RequestMapping("addDistrict")
    public String addDistrict(District district){
        try {
            //调用业务
            int result=districtService.addDistrict(district);
            //封装返回数据
            // Map<String,Object> map=new HashMap<>();   //自动转json
            // map.put("result",result);
            return "{\"result\":"+result+"}";   //拼接的json
        }catch (Exception e){
            return "{\"result\":-1}";
        }
    }

        //修改区域
        @RequestMapping("updateDistrict")
        public String updateDistrict(District district){
            try {
                //调用业务
                Integer result=districtService.updateDistrict(district);
                //封装返回数据
                // Map<String,Object> map=new HashMap<>();   //自动转json
                // map.put("result",result);
                return "{\"result\":"+result+"}";   //拼接的json
            }catch (Exception e){
                return "{\"result\":-1}";
            }
        }


    //获取单条数据
    @RequestMapping("getDistrict")
    public District grtDistrict(Integer id) {
        try {
            return districtService.getDistrict(id);
        }catch (Exception e){

        }
        return null;
    }

    //删除
    @RequestMapping("delDistrict")
    public String delDistrict(Integer id){
        try {
            Integer result = districtService.deleteDistrict(id);
            return "{\"result\":"+result+"}";
        }catch (Exception e){
            return "{\"result\":-1}";
        }
    }

    //批量删除区域
    //前台传递数据的格式:ids=1,2,3,4     后台: String ids变量接收数据
    //前台传递数据的格式:ids=1&ids=2&ids=3     后台: Integer []ids变量接收数据
    @RequestMapping("delMoreDistrict")
    public String delMoreDistrict(String ids){
        try {
            String[] strList = ids.split(",");
            Integer[] idList=new Integer[strList.length];
            for (int i=0;i<strList.length;i++){
                idList[i]=new Integer(strList[i]);
            }
            //调用业务
            Integer temp = districtService.deleteMoreDistrict(idList);
            return "{\"result\":"+temp+"}";   //拼接的json
        }catch (Exception e){
            e.printStackTrace();   //使用日志工具记录
            return "{\"result\":-1}";
        }
        }
    }


