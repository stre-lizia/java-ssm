package org.xueyinhu.ssm.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Employee {

    private Integer emp_id;
    @NotBlank
    private String emp_name;
    @NotNull
    private Double emp_salary;
}
