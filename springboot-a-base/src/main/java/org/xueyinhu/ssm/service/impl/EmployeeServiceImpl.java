package org.xueyinhu.ssm.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xueyinhu.ssm.mapper.EmployeeMapper;
import org.xueyinhu.ssm.pojo.Employee;
import org.xueyinhu.ssm.service.EmployeeService;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
        private EmployeeMapper empMapper;
    @Override
    public List<Employee> findList() {
        List<Employee> employeeList = empMapper.queryAll();
        log.info("查询全部数据:{}",employeeList);
        return employeeList;
    }
}
