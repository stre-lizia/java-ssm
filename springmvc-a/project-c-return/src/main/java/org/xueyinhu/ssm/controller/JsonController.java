package org.xueyinhu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xueyinhu.ssm.pojo.User;

// @Controller
@RestController // todo = @Controller + @ResponseBody
@RequestMapping("json")
public class JsonController {

    @GetMapping("data")
    // @ResponseBody 直接返回 handlerAdapter 处理后的 json 数据，不寻找视图解析器
    public User data() {
        User user = new User();
        user.setName("zhang_san");
        user.setAge(18);
        return user;
    }
}
