package org.xueyinhu.ssm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xueyinhu.ssm.pojo.Employee;
import org.xueyinhu.ssm.service.EmployeeService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService userService;

    @GetMapping("/list")
    @ResponseBody
    public List<Employee> getEmp(){
        List<Employee> empList = userService.findList();
        log.info("查询的 Employee 数据为:{}", empList);
        return empList;
    }

}
