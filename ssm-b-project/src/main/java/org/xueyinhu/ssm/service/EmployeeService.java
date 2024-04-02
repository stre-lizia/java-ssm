package org.xueyinhu.ssm.service;

import org.xueyinhu.ssm.pojo.Employee;
import org.xueyinhu.ssm.utils.R;

import java.util.List;

public interface EmployeeService {
    R page(int pageSize, int currentPage);
    R save(Employee employee);
    R remove(Integer id);
    R update(Employee employee);
}
