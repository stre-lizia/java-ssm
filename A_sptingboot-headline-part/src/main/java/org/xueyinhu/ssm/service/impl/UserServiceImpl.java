package org.xueyinhu.ssm.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xueyinhu.ssm.mapper.UserMapper;
import org.xueyinhu.ssm.pojo.User;
import org.xueyinhu.ssm.service.UserService;
import org.xueyinhu.ssm.utils.JwtHelper;
import org.xueyinhu.ssm.utils.MD5Util;
import org.xueyinhu.ssm.utils.Result;
import org.xueyinhu.ssm.utils.ResultCodeEnum;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private  UserMapper userMapper;

    /**
     * 登录业务实现
     * @param user
     * @return result封装
     */
    @Override
    public Result login(User user) {

        //根据账号查询
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        User loginUser = userMapper.selectOne(queryWrapper);

        //账号判断
        if (loginUser == null) {
            //账号错误
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        //判断密码
        if (!StringUtils.isEmpty(user.getUserPwd())
                && loginUser.getUserPwd().equals(MD5Util.encrypt(user.getUserPwd())))
        {
            //账号密码正确
            //根据用户唯一标识生成token
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));

            Map data = new HashMap();
            data.put("token",token);

            return Result.ok(data);
        }

        //密码错误
        return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
    }
}
