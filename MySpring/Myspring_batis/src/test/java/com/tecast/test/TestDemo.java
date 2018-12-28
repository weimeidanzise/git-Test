package com.tecast.test;

import com.itcast.domain.Account;
import com.itcast.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestDemo {

    public static void main(String[] args) throws Exception {
        InputStream is = Resources.getResourceAsStream("com/itcast/mapper/sqlConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println(account);
        }

    }
    @Test
    public void test1 () {
        System.out.println("hello");
    }
}
