package com.itcast.dao;

import com.itcast.domain.Pages;
import com.itcast.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //    List<User> findAll() throws Exception;
    List<User> findAll(Pages pages) throws Exception;

    User findUser(User user) throws Exception;

    void saveUser(User user) throws Exception;

    User updateUser(Integer id) throws Exception;

    void deleteUser(Integer id) throws Exception;

//    int findTotalCount(Map<String,String[]> condition);
//
//    List<User> findByPage(int startNum,int rows,Map<String,String[]>condition);

    //分页查询
    List<User> findPages(Pages pages) throws Exception;
}
