package org.xueyinhu.ssm;

public class Main {

    /** Mybatis 插件使用（拦截器，后置修改 SQL 语句） --> PageHelper 使用
     * 1. pom.xml 中引入 pagehelper 依赖
     * 2. 在 Mybatis-config.xml 中进行配置
     *  <plugins>
     *      <plugin interceptor="com.github.pagehelper.PageInterceptor">
     *          <property name="helperDialect" value="mysql"/>
     *      </plugin>
     *  </plugins>
     * 3. 在 mapper.xml 中写的 sql 语句不要分号结尾
     * 4. 在使用 Mapper 时候，
     *  // 调用之前先设置分页数据
     *  PageHelper.startPage(pageNum. pageSize);
     *  // 正常使用
     *  List<Employee> list = mapper.queryList();
     *  // 将查询数据封装为 PageInfo 的分页实体类
     *  PageInfo<Employee> pageInfo = new PageInfo<>(list);
     *  // 获取信息
     *  ......
     *  ---------------------------
     *  todo 注意不能将两条查询装到一个分页区
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /** ORM 与 逆向工程
     * ORM (对象-关系映射)是一种将数据库和面向对象编程语言中的对象之间进行转换的技术，
     *  将对象和关系数据库的概念进行映射，最后就能调用方法进行数据库操作
     * 逆向工程：半自动 ORM -> 全自动 ORM
     */
    public void sayOhNo() {
        System.out.println("社区版还用不了 database + mybatisX 的组合");
    }
}