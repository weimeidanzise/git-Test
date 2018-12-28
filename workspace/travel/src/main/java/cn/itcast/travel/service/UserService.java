package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

public interface UserService {
    //注册 激活 登录 三个方法

    boolean regist(User user);

    boolean active(String code);

    User login(User user);
}
