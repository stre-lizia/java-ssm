package org.xueyinhu.ssm.pojo;

import lombok.Data;

@Data
public class Order {
    private Integer orderId;
    private String orderName;
    private Integer customerId;

    // 一个订单对应一个客户，设置一个实体类对象接值
    private Customer customer;
}
