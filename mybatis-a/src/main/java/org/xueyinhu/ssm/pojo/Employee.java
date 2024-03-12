package org.xueyinhu.ssm.pojo;

/**
 * use studb;
 * create table t_emp (
 * 	emp_id INT AUTO_INCREMENT,
 * 	emp_name CHAR(100),
 * 	emp_salary DOUBLE(10,5),
 * 	PRIMARY KEY(emp_id)
 * );
 */
public class Employee {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return Salary;
    }

    public void setSalary(Float salary) {
        Salary = salary;
    }

    private Integer id;
    private String name;
    private Float Salary;

}
