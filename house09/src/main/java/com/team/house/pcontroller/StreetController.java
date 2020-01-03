package com.team.house.pcontroller;

import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller("StreetController2")
@RequestMapping("/page/")
public class StreetController {
        @Autowired
        private StreetService streetService;

        @RequestMapping("getStreetByDid")
        @ResponseBody
        public List<Street> getStreetByDid(Integer did){
            return  streetService.getStreetByDistrict(did);
        }
    }

