package org.xueyinhu.ssm;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.xueyinhu.ssm.controller.StudentController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {

    /** mysql
     * JdbcTemplate 简化了数据库的 curd 操作，但是不提供连接池
     * DruidDataSource 负责连接的创建和数据库驱动的注册等
     * -
     * // 连接池对象
     * DruidDataSource ds = new DruidDataSource();
     * // url 地址
     * ds.setUrl("jdbc:mysql:///studb");
     * // jdbc 驱动
     * ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
     * // 账号
     * ds.setUsername("root");
     * // 密码
     * ds.setPassword("password");
     * // 实例化
     * JdbcTemplate jd = new JdbcTemplate();
     * // 设置连接池
     * jd.setDataSource(ds);
     * -
     * 非查询语句 jt.update();
     * 查询单个对象语句 jt.queryForObject();
     * 查询集合语句 jt.query();
     */
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = applicationContext.getBean(JdbcTemplate.class);

        // 添加一条学生信息
        // String sql 可以带有占位符，？只能代表值，不能代表关键字或容器名
        String sql1 = "insert into students (id, name, gender, age, class) value (?, ?, ?, ?, ?);";
        // 参数：string sql，占位符的值（可选）
        // 返回：int 影响行数
        int rows = jt.update(sql1, 9, "二梁", "男", 24, "五年一班");
        System.out.println("rows = " + rows);

        // 查询某个 id 的学生
        String sql2 = "select * from students where id = ?;";
        // 参数：string sql，RowMapper 列名和属性名的映射器接口，占位符的值（可选）
        // 返回：RowMapper 指定的值
        Student student = jt.queryForObject(sql2, new RowMapper<Student>() {
            @Override
            // rs->结果集 rowNum->行数
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setClasses(rs.getString("class"));
                return student;
            }
        }, 1);
        System.out.println("student = " + student);

        // 查询所有学生
        String sql3 = "select id, name, gender, age, class as classes from students;";
        // TODO BeanPropertyRowMapper 自动映射列和属性名，要求列名与属性名一致，若不一致则可取别名映射
        List<Student> studentList = jt.query(sql3, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void testForController() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        StudentController sc = applicationContext.getBean(StudentController.class);
        sc.findAll();
    }
}