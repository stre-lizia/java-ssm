package org.xueyinhu.ssm;

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
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}