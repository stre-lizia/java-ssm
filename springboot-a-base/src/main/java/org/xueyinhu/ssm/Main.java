package org.xueyinhu.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 启动类
 * 1. 配置类 @SpringBootConfiguration
 * 2. 自动加载配置 @EnableAutoConfiguration
 * 3. 扫描当前类所在的包 @ComponentScan
 */

@MapperScan("org.xueyinhu.ssm.mapper")
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // todo 自动创建 Ioc 容器，启动 tomcat 服务器
        SpringApplication.run(Main.class, args);
    }
}
