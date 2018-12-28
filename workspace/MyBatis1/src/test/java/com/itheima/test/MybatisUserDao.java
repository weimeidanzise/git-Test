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

public class MybatisUserDao {
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void findAll() {
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        List<User> list = dao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        session.close();


    }



}
