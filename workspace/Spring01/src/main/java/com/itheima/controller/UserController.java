package com.itheima.controller;

import com.itheima.dao.UserService;
import com.itheima.factory.BeanFactory;

public class UserController {
    public static void main(String[] args) {
        UserService userService= (UserService) BeanFactory.getBean("userService");
        userService.findAll();
    }


}
