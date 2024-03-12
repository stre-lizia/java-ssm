package org.xueyinhu.ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.xueyinhu.ssm.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    Employee queryById(Integer id);

    int insertEmp(Employee employee);

    List<Employee> queryByNameAndSalary(@Param("A") String name, @Param("bb") Double salary);

    int insertEmpFromMap(Map<String, Double> employeeMaps);
}
