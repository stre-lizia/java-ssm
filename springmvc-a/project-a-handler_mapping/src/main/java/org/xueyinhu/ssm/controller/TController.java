package org.xueyinhu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TController {

    /** 注解 @RequestMapping(address) 对外访问的地址，注册到 HandlerMapping
     * 1. 可以加在方法上或者类上
     *  类上是类中方法通用的访问地址，前缀
     *  方法上是具体的 handler 地址
     *  todo 总地址：类地址 + 方法地址
     * 2. 地址写法：
     *  1，精准地址（一个或多个） {"地址 1", "地址 2"}
     *  2。支持模糊 * 任意一层字符串 | ** 任意层字符串
     * 3. 请求方式指定
     *  \ @RequestMapping(value="", method=?)
     *  若不符合请求方式，则会报错：405异常
     * 4. 注解进阶 只能使用在方法上
     * \ @GetMapping(value) = @@RequestMapping(value, method=RequestMethod.GET)
     */
    @RequestMapping(value = "springmvc/sayHello", method = {RequestMethod.POST, RequestMethod.GET})
    // @ResponseBody 只返回字符串给前端，不要找视图解析器
    @ResponseBody
    public String sayHello() {
        System.out.println("TController.sayHello");
        return "t springmvc";
    }
}
