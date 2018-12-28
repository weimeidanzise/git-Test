package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

//    @Select("select * from user where id = #{id}")
    public User findById(int id);

    public User addUser();

    @Select("select count(*) from user")
    public int findTotal();
}
