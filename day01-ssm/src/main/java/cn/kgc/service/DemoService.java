package cn.kgc.service;

import cn.kgc.domain.Emp;
import cn.kgc.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DemoService {

    List<Emp> findEmpAll();
}
