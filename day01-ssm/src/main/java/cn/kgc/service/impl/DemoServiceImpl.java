package cn.kgc.service.impl;

import cn.kgc.domain.Emp;
import cn.kgc.domain.EmpExample;
import cn.kgc.mapper.EmpMapper;
import cn.kgc.service.DemoService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Emp> findEmpAll() {
        //使用dao层的selectByExample
        EmpExample empExample = new EmpExample();
        return empMapper.selectByExample(empExample);
       /* EmpExample empExample = new EmpExample();
        EmpExample.Criteria  criteria = empExample.createCriteria();
        criteria.andDidEqualTo(1);
        return empMapper.selectByExample(empExample);*/
       /*EmpExample empExample1 = new EmpExample();
       EmpExample.Criteria criteria = empExample.createCriteria();
       criteria.andDidEqualTo(2);
       criteria.andEnameLike("%t%");
       return empMapper.selectByExample(empExample);*/
    }

    }
