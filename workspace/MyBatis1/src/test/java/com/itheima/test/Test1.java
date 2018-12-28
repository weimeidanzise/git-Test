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

public class Test1 {
    private SqlSession session;
    private SqlSessionFactory factory;
    private InputStream in;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();

    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setName("卡特琳娜");
        user.setAge(22);
        user.setGender("女");
        UserDao mapper = session.getMapper(UserDao.class);
        User users = mapper.addUser();
        System.out.println(users);
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
    public void findById(){
        UserDao mapper = session.getMapper(UserDao.class);
        User byId = mapper.findById(103);
        System.out.println(byId.getName());
        System.out.println(byId);
    }
    @Test
    public void findTotal(){
        UserDao mapper = session.getMapper(UserDao.class);
        int total = mapper.findTotal();
        System.out.println(total);
    }
}
