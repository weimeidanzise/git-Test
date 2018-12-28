package com.itheima.test;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisDemo1 {
    private SqlSession session;
    @Before
    public void init()throws Exception{
        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

         session = factory.openSession();
    }
    @After
    public void destory(){
//        session.commit();
        session.close();
    }
    @Test
    public void findAll()throws Exception{
//        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");

        List<User> users = session.selectList("com.itheima.findAll");
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }
    @Test
    public void findById() throws Exception{
        User user = session.selectOne("com.itheima.findById", 3);
        System.out.println(user);

    }
    @Test
    public void findByName() throws Exception{
        List<User> user = session.selectList("com.itheima.findByName", "%卢本伟%");
        for (User user1 : user) {
            System.out.println(user1);
        }


    }

}
