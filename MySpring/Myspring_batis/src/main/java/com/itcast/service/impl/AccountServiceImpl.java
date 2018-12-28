package com.itcast.service.impl;

import com.itcast.domain.Account;
import com.itcast.mapper.AccountMapper;
import com.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public void save(Account account) throws Exception {
        accountMapper.save(account);
    }

    public List<Account> findAll() throws Exception {
        return accountMapper.findAll();
    }
}
