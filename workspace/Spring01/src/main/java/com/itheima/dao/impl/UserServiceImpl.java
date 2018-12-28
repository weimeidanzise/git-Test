package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.UserService;
import com.itheima.factory.BeanFactory;

public class UserServiceImpl implements UserService {
    public UserDao userDao =(UserDao) BeanFactory.getBean("userDao");

    public void findAll() {
        userDao.findAll();
    }
}
