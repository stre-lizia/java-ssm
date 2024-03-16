package org.xueyinhu.ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.xueyinhu.ssm.pojo.Employee;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface EmployeeMapper {

    Employee queryById(Integer id);

    int insertEmp(Employee employee);

    List<Employee> queryByNameAndSalary(@Param("A") String name, @Param("bb") Double salary);

    int insertEmpFromMap(Map<String, Double> employeeMaps);


    // 如果是 DML 语句（插入 修改 删除），建议返回 int
    int queryNameById(Integer id);

    Employee queryByName();

    Map<String, Objects> selectEmpNameAndMaxSalary();

    List<String> queryNameBySalary();

    int insertEmpOther(Employee employee);
}
