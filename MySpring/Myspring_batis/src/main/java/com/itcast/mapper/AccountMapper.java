package com.itcast.mapper;

import com.itcast.domain.Account;

import java.util.List;

public interface AccountMapper {
    List<Account> findAll() throws Exception;
    //保存账户信息
    void save(Account account) throws Exception;
}
