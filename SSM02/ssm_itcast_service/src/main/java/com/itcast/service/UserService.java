package com.itcast.service;

import com.itcast.domain.Pages;
import com.itcast.domain.User;

import java.util.List;

public interface UserService {
    User findUser(User user) throws Exception;

//    List<User> findAll() throws Exception;

    void saveUser(User user) throws Exception;

    User updateUser(Integer id) throws Exception;

    void deleteUser(Integer id) throws Exception;

    List<User> findAll(Pages pages)throws  Exception;

}
