package org.xueyinhu.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xueyinhu.ssm.pojo.User;
import org.xueyinhu.ssm.utils.Result;

public interface UserService extends IService<User> {
    Result login(User user);
}
