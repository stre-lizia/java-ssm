package org.xueyinhu.ssm;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

// 扫描的包
@ComponentScan("org.xueyinhu.ssm.components")
// 外部配置文件
@PropertySource(value = "classpath:jdbc.properties")
// 配置类
@Configuration
public class FConfiguration {

    // 非全局使用
    //    @Value("${data.url}")
    //    private String url;
    //    @Value("${data.driver}")
    //    private String driver;
    //    @Value("${data.username}")
    //    private String username;
    //    @Value("${data.password}")
    //    private String password;

    /** 第三方
     * ---
     * \ @Bean(name="") 会覆盖方法名
     * ---
     * bean 的周期方法如何指定
     *  1. @PostConstruct + @PreDestroy
     *  2. @Bean(initMethod="", destroyMethod="")
     * ---
     * bean 的 scope 指定
     * \ @Scope
     * ---
     * 如何引用其他的 IOC 组件
     *  1. 要使用的组件也是 @Bean 方法，可以直接进行调用，不推荐
     *  2. 在形参列表声明想要的组件类型，必须要有对应组件，若多个对应组件，需要形参名称等于对应的 bean-name
     */
    @Bean(name = "ds") // Bean 注解真正配置到 IOC 容器
    public DruidDataSource dataSource(
            // 可以在形参中进行定义
            @Value("${data.url}") String url,
            @Value("${data.driver}") String driver,
            @Value("${data.username}") String username,
            @Value("${data.password}") String password
    ) {
        DruidDataSource source = new DruidDataSource();
        source.setUrl(url);
        source.setDriverClassName(driver);
        source.setUsername(username);
        source.setPassword(password);
        return source;
    }

    // 使用其他 IOC 组件
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource ds) {
        JdbcTemplate jt = new JdbcTemplate();
        // ？
        // jt.setDataSource(dataSource());
        jt.setDataSource(ds);
        return jt;
    }

    // @Import 允许从另一个配置类中加载 @Bean 定义
    // @Import(OtherConfig.class)
}
