package org.xueyinhu.ssm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.xueyinhu.ssm.pojo.Employee;
import org.xueyinhu.ssm.service.EmployeeService;
import org.xueyinhu.ssm.utils.R;

import java.util.List;

// todo 允许其他源访问我们的 controller，浏览器就不进行拦截了
@CrossOrigin
@RestController
@RequestMapping("emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/{pageSize}/{currentPage}")
    public R page(
            @PathVariable(name = "pageSize") int pageSize,
            @PathVariable(name = "currentPage") int currentPage
    ) {
        return employeeService.page(pageSize, currentPage);
    }

    @PostMapping
    public R save(@Validated @RequestBody Employee employee, BindingResult result){
        if (result.hasErrors()) {
            return R.fail("参数错误!");
        }
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public R remove(@PathVariable(name = "id") Integer id){
        return employeeService.remove(id);
    }

    @PutMapping
    public R change(@Validated @RequestBody Employee employee, BindingResult result){
        if (result.hasErrors()) {
            return R.fail("参数错误!");
        }
        return employeeService.update(employee);
    }
}
