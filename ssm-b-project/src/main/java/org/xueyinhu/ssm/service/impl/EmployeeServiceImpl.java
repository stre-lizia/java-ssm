package org.xueyinhu.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xueyinhu.ssm.mapper.EmployeeMapper;
import org.xueyinhu.ssm.pojo.Employee;
import org.xueyinhu.ssm.service.EmployeeService;
import org.xueyinhu.ssm.utils.PageBean;
import org.xueyinhu.ssm.utils.R;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public R page(int pageSize, int currentPage) {
        PageHelper.startPage(currentPage, pageSize);
        List<Employee> employees = employeeMapper.queryList();
        PageInfo<Employee> info = new PageInfo<>(employees);
        PageBean<Employee> pageBean = new PageBean<>(currentPage, pageSize, info.getTotal(), info.getList());
        return R.ok(pageBean);
    }

    @Override
    public R save(Employee employee) {
        int rows = employeeMapper.insert(employee);
        if (rows > 0) {
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public R remove(Integer id) {
        int rows = employeeMapper.delete(id);
        if (rows > 0) {
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public R update(Employee employee) {
        if (employee.getEmp_id() == null) {
            return R.fail("核心参数不能为空");
        }
        int rows = employeeMapper.update(employee);
        if (rows > 0) {
            return R.ok(null);
        }
        return R.fail(null);
    }
}
