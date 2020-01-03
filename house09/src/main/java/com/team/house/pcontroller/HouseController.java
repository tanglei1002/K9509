package com.team.house.pcontroller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.Users;
import com.team.house.service.HouseService;
import com.team.until.PageUtil;
import com.team.until.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller(value = "houseController")
@RequestMapping("/page/")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("addHouse")
    public String addHouse(HttpSession session, House house,@RequestParam(value = "pfile",required = false) CommonsMultipartFile pfile ){
        try {
            //1.实现文件上传
           /* System.out.println("上传文件名称:"+pfile.getOriginalFilename());
            System.out.println("上传文件大小:"+pfile.getSize());
            System.out.println("上传文件的类型:"+pfile.getContentType());*/

            //上传
            //获取文件的扩展名
            String fname=pfile.getOriginalFilename();
            String fexpName=fname.substring(fname.lastIndexOf("."));
            //生成新的文件名
            String unique=System.currentTimeMillis()+"";
            String saveFileName=unique+fexpName;
            String savePath="E:/U4/"+saveFileName;
            File savefile=new File(savePath);
            pfile.transferTo(savefile); //上传

            //2.将数据添加到数据库
            //修改house实体，添加额外的属性值
            //设置编号
            house.setId(unique);
            //设置所属用户   重点理解
            Users user=(Users)session.getAttribute("loginInfo");
            house.setUserId(user.getId());
            //设置图片路径
            house.setPath(saveFileName);

            //调用业务实现添加
            houseService.addHouse(house);
            return "fabu";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("showHouse")
    public String showHouse(PageUtil pageUtil, HttpSession session, Model model){
        pageUtil.setRows(5);
        Users users =  (Users)session.getAttribute("loginInfo");
        PageInfo<House> pageInfo = houseService.getHouseByUser(users.getId(),pageUtil);
        model.addAttribute("pageInfo",pageInfo);
        return "guanli";


    }
    @RequestMapping("editHouse")
    public String editHouse(String id,Model model){
        House house = houseService.getHouse(id);
        model.addAttribute("house",house);
        return "upfabu";
    }
    @RequestMapping("deleteHouse")
    public String delteHouse(String id){
        try {
            Integer temp = houseService.deleteHouse(id, 1);
            return "redirect:showHouse";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "errror";
    }

    @RequestMapping("/broswerHouse")
    public String broswerHouse(SearchCondition searchCondition, Model model){
        searchCondition.setRows(5);
        PageInfo<House> pageInfo = houseService.getBroswerHouse(searchCondition);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("searchCondition",searchCondition);
        return "list";
    }

}
