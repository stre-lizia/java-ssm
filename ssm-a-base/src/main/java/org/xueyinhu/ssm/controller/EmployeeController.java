package org.xueyinhu.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xueyinhu.ssm.pojo.Employee;
import org.xueyinhu.ssm.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("find")
    public List<Employee> find() {
        return employeeService.findAll();
    }
}
