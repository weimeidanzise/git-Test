package cn.itcast.mapper;

import cn.itcast.domain.User;

import java.util.List;

public interface UserMapper {
    //遍历所有用户信息
    List<User> findAll() throws Exception;
}
