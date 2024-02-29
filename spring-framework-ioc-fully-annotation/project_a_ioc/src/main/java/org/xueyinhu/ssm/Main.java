package org.xueyinhu.ssm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.xueyinhu.ssm.components.Student;

public class Main {

    /** 完全注解配置方式
     * 使用配置类代替配置文件 @Configuration ，对于 XML 配置方式
     *  包扫描配置 <bean/> to @Bean
     *  引用外部的配置文件 <context:component-scan base-package/> to @ComponentScan
     *  DI <context:property-placeholder/> to @PropertySource
     */
    public static void main(String[] args) {
        // 创建 IOC 容器
        ApplicationContext context = new AnnotationConfigApplicationContext(FConfiguration.class);
        Student student = context.getBean(Student.class);
    }
}
