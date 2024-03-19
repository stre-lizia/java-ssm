package org.xueyinhu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TController {

    // @RequestMapping(address) 对外访问的地址，注册到 HandlerMapping
    @RequestMapping("springmvc/sayHello")
    // @ResponseBody 只返回字符串给前端，不要找视图解析器
    @ResponseBody
    public String sayHello() {
        System.out.println("TController.sayHello");
        return "t springmvc";
    }
}
