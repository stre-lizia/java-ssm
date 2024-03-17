package org.xueyinhu.ssm.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private Integer customerId;
    private String customerName;

    // 一对多关系，定义一个实体类集合类型接值
    private List<Order> orderList;
}
