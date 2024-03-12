package org.xueyinhu.ssm;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.xueyinhu.ssm.mapper.EmployeeMapper;
import org.xueyinhu.ssm.pojo.Employee;

import java.io.IOException;
import java.io.InputStream;

/** MyBatis
 * 持久化框架对比：
 *  JDBC：
 *      SQL 夹杂在代码中耦合度过高，不容易维护且开发效率低
 *      运行效率最高 -- JDBC > Mybatis > Hibernate
 *  Hibernate 和 JPA：
 *      开发效率比直接使用 JDBC 高 -- JDBC < Mybatis < Hibernate
 *      程序中的长难复杂 SQL 需要绕过框架
 *      内部自动生成的 SQL，不容易做特殊优化
 *      基于全映射的全自动框架，大量字段的 POJO 进行部分映射时比较困难
 *      反射操作太多，导致数据库性能下降
 *  MyBatis
 *      轻量级，性能出色
 *      SQL 和 Java 编码分开，功能边界清晰
 *      开发效率逊于 Hibernate，但是完全能够接受
 */
public class Main {

    /** mybatis
     * 1. 读取外部配置文件 mybatis-config.xml
     * 2. 创建 SqlSessionFactory 对象
     * 3. 创建 SqlSession，每次业务创建一个，用完释放
     * 4. 获取接口的代理对象，就会查找 mapper 接口的方法
     * 5。 提交事务（非DQL）和释放资源
     */
    public static void main(String[] args) throws IOException {

        String mybatisConfigFilePath = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        System.out.println(mapper.queryById(1).getName());

        // 查询事务不需要提交
        // session.commit();
        session.close();
    }
}