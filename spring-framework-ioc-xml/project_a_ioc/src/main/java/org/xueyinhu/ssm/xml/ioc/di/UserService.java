package org.xueyinhu.ssm.xml.ioc.di;

public class UserService {
    private UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
}


