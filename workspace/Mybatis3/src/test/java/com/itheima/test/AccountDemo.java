package com.itheima.test;

import com.itheima.dao.AccountDao;

import com.itheima.domain.Account;
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

public class AccountDemo {
    private SqlSession session;
    private SqlSessionFactory factory;
    private InputStream in;
    private AccountDao accountDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        accountDao = session.getMapper(AccountDao.class);

    }
    @After
    public void destroy() throws Exception {
        // 释放资源
        session.commit();
        //7. 释放资源
        session.close();
        in.close();
    }
    @Test
    public void findAll(){
        List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.println("``````````````````````````````````````````");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
