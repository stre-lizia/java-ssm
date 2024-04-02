package org.xueyinhu.ssm.mapper;

import org.xueyinhu.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> queryList();
    int insert(Employee employee);
    int delete(Integer emp_id);
    int update(Employee employee);
}
