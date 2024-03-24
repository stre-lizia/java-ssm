package org.xueyinhu.ssm.controller;

import org.xueyinhu.ssm.pojo.User;

public class JsonController {

    public User data() {
        User user = new User();
        user.setName("zhang_san");
        user.setAge(18);
        return user;
    }
}
