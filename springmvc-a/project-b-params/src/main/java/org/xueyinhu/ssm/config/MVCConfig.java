package org.xueyinhu.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@EnableWebMvc // handlerAdapter 配置 json 转换器
// todo jackson-databind 实际上不仅添加了 json 处理器，还添加了 RequestMappingHandlerMapping 和 RequestMappingHandlerAdapter
// 所以下面可以省略
@Configuration
@ComponentScan("org.xueyinhu.ssm.controller")
public class MVCConfig {
//    @Bean
//    RequestMappingHandlerMapping handlerMapping() {
//        return new RequestMappingHandlerMapping();
//    }
//
//    @Bean
//    RequestMappingHandlerAdapter handlerAdapter() {
//        return new RequestMappingHandlerAdapter();
//    }
}
