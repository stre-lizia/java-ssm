package org.xueyinhu.ssm.configs;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.xueyinhu.ssm")
@PropertySource("classpath:jdbc.properties")
// @EnableAspectJAutoProxy
@EnableTransactionManagement // todo 开启事务注解的支持
public class SqlConfig {

    @Value("${data.driver}")
    private String driver;

    @Value("${data.url}")
    private String url;

    @Value("${data.username}")
    private String username;

    @Value("${data.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean

    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        // 内部要进行事务的操作
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        // todo 设置连接池
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
