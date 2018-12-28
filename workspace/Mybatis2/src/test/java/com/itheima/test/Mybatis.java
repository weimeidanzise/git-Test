package com.itheima.test;

import com.itheima.dao.UserDao;
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

public class Mybatis {
    private SqlSession session;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
    }

    @Test
    public void findTotal() {
        UserDao mapper = session.getMapper(UserDao.class);
        int total = mapper.findTotal();
        System.out.println(total);
    }

    @After
    public void destroy() {
//        session.commit();
//        session.close();
    }

    @Test
    public void addUser() {
       UserDao mapper = session.getMapper(UserDao.class);
        User user = new User();
        user.setName("本兮");
        user.setAge(23);
        user.setGender("女");
        mapper.addUser(user);
        System.out.println(user);
    }

    @Test
    public void findById() {
        UserDao mapper = session.getMapper(UserDao.class);
        User byId = mapper.findById(18);
        System.out.println(byId.getName());
        System.out.println(byId);

    }

    @Test
    public void update() {
        UserDao mapper = session.getMapper(UserDao.class);
        User user = new User();
        user.setId(4);
        user.setName("本兮");
        mapper.update(user);


    }

    @Test
    public void findAll() {
        UserDao mapper = session.getMapper(UserDao.class);
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void findByName() {
        UserDao mapper = session.getMapper(UserDao.class);
        List<User> byName = mapper.findByName("%本%");
        System.out.println(byName);
    }
}
