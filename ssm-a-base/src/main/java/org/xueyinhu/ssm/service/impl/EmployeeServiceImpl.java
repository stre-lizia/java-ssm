package org.xueyinhu.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xueyinhu.ssm.mapper.EmployeeMapper;
import org.xueyinhu.ssm.pojo.Employee;
import org.xueyinhu.ssm.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> findAll() {
        return employeeMapper.queryList();
    }
}
