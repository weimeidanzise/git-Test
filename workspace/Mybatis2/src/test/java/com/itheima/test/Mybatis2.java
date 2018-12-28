package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatis2 {
    SqlSessionFactory factory;
    SqlSession session;
    InputStream in;
    @Before
    public void init() throws IOException {
         in = Resources.getResourceAsStream("sqlMapConfig.xml");
         factory = new SqlSessionFactoryBuilder().build(in);
         session=factory.openSession();
    }
    @After
    public void destroy(){
        session.commit();
        session.close();
    }
    @Test
    public void addUser(){/*
        User user=new User();
        user.setId(100);
        user.setName("小小");
        user.setGender("女");
        user.setAge(22);
        UserDao mapper = session.getMapper(UserDao.class);
        mapper.addUser(user);*/

    }
    @Test
    public void findByVo(){
        User user=new User();
        QueryVo vo=new QueryVo();
        user.setName("%本%");
        vo.setUser(user);
        UserDao mapper = session.getMapper(UserDao.class);
        List<User> byVo = mapper.findByVo(vo);
        System.out.println(byVo);
    }
}
