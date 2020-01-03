package cn.kgc.controller;

import cn.kgc.domain.Emp;
import cn.kgc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private DemoService demoService;
/*@RequestMapping("/list")
    public String list(Model model){
    List<Emp> empList = demoService.findEmpAll();
    model.addAttribute("empList",empList);
    return "main";
}*/
    @RequestMapping("/getemp")
    @ResponseBody
    public List<Emp> getemp(){
        List<Emp> list = demoService.findEmpAll();
        return list;
    }
}
//@ResponseBody注解
//1.表示将方法返回值输出到页面中
//2.将返回的java对象转化json字符串进行返回  ===>依赖jackson