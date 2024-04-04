package org.xueyinhu.ssm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xueyinhu.ssm.mapper.UserMapper;
import org.xueyinhu.ssm.pojo.User;

import java.util.List;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        System.out.println(("------ select all method test ------"));
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        System.out.println(("------ insert user method test ------"));
        User user = new User();
        user.setAge(22);
        user.setName("浮浮");
        user.setEmail("213@t.com");
        int rows = userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void testPageQuery(){
        //设置分页参数
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }

    @Test
    public void testPageQueryByAge() {
        Page<User> page = new Page<>(1, 2);
        userMapper.queryByAge(page, 20);
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }

    // Wrapper
    @Test
    public void testWrapper_1() {
        // 查询用户名包含 a，年龄在 20 到 30 之间，而且邮箱不为 null 的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testLambdaWrapper_1() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .like(User::getName, "a")
                .between(User::getAge, 20, 30)
                .isNotNull(User::getEmail);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(System.out::println);
    }
}
