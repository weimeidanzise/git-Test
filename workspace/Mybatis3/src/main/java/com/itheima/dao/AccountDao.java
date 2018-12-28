package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    List<Account> findAllAccount();


}
