package org.xueyinhu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xueyinhu.ssm.pojo.JsonUser;

@Controller
@RequestMapping("param")
@ResponseBody
public class ParamController {

    /** 接收 Param，常见于 Get 请求 /data?name=username&age=14
     * 使用 @RequestParam 在形参列表指定，默认必须传递否则报错，
     *  value 属性用于映射 请求名称 与 形参名称
     *  是否必须传递可以使用 require 指定，
     *  默认值可以使用 defaultValue 指定
     * 若出现一参多值的情况，则直接形参使用集合类型接值
     * 可以使用实体类进行接值，只需要将类声明在形参列表
     */
    @RequestMapping("data")
    public String data1(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "age", defaultValue = "1") int age) {
        System.out.println("name = " + name + ", age = " + age);
        return "name = " + name + ", age = " + age;
    }

    /** 接收 动态路径
     * \ @RequestMapping("{username}/{password}")
     * 形参列表需要使用 @PathVariable 指定，否则默认接收 param 参数
     */
    @RequestMapping("{username}/{password}")
    public String path1(@PathVariable String username, @PathVariable String password) {
        return "username";
    }

    /** 接收 Json 用于 Post 请求
     * Java 原生的 api 不支持 JSON 格式
     *  1. 导入处理 JSON 的依赖
     *  <dependency>
     *    <groupId>com.fasterxml.jackson.core</groupId>
     *    <artifactId>jackson-databind</artifactId>
     *    <version>2.17.0</version>
     * </dependency>
     *  2. handlerAdapter 配置 JSON 转化器
     *  add @EnableWebMvc for MVC Config Class
     */
    @PostMapping("json")
    public String json1(@RequestBody JsonUser jsonUser) {
        return "1";
    }

    /** 接收 Cookie
     *
     */
    @RequestMapping("cookie")
    public String cookie1(@CookieValue(value = "cookieName") String value) {
        return "cookie";
    }

    /** 接收 请求头
     *
     */
    @RequestMapping("head")
    public String head1(@RequestHeader("Host") String host) {
        return "head";
    }

    /** 接收原生 API
     * ServletContext
     *  作用：1. 最大的配置文件 2. 全局最大共享域 3. 核心Api
     *  获取：
     *      require 获取，session 获取
     *      全局注入
     */
}
