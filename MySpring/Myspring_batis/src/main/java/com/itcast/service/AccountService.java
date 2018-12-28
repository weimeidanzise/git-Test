package com.itcast.service;

import com.itcast.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll() throws Exception;
    //保存账户信息
    void save(Account account) throws Exception;
}
