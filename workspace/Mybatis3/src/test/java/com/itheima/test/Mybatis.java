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
    private InputStream in;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();

    }


}
