package org.xueyinhu.ssm.mapper;

import org.xueyinhu.ssm.pojo.Customer;
import org.xueyinhu.ssm.pojo.Order;

import java.util.List;

public interface OrderMapper {
    Order queryOrderById(Integer id);

    List<Customer> queryList();
}
