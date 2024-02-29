package org.xueyinhu.ssm;

public class Main {

    /** 不重复进行三层架构的练习，说一些关键点
     * IOC 注解
     * \ @Component
     * \ @Controller
     * \ @Service
     * \ @Repository
     * DI 注解
     * \ @Autowired
     * \ @Qualifier(value="")
     * \ @Resource(name="")
     * \ @Value(${key:value})
     * 配置文件
     * \ 扫描注解
     * \ 引入外部的配置文件
     * todo \ 第三方类的 IOC 与 DI 配置
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}