package org.xueyinhu.ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.xueyinhu.ssm.pojo.Employee;

import java.util.List;


public interface EmployeeMapper {

    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);

    int update(Employee employee);
}
