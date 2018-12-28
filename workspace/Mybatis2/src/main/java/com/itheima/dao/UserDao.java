package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao  {
    public List<User> findAll();

    @Select("select * from user  where id=#{id}")
    public User findById(int id);

    @Update("update user set name = #{name} where id = #{id}")
    public void update(User user);

    public int findTotal();

    public void addUser(User user);

    public List<User> findByVo(QueryVo vo);

    public List<User> findByName(String name);
}
