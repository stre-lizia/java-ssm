package org.xueyinhu.ssm;

import org.springframework.stereotype.Component;

/** 注解 配置 IOC 容器
 * -------------------------------- 注解类型（功能上没有任何区别） ------------------------------------------
 * \@Component 用于描述 Bean，泛化概念，标识容器中的一个组件
 * \@Repository 用于数据访问层（Dao）
 * \@Service 用于业务层（Service）
 * \@Controller 用于控制层（Controller）
 */
@Component // id=“main” class="Main"
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
