package com.gxitsky.dao.impl;

import com.gxitsky.dao.AccountDao;
import com.gxitsky.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * @name: AccountDaoImpl
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-06 16:06
 **/
@Repository
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account findById(String id) {
        Account account = new Account(id, "admin" + id, "123456" + id);
        System.out.println("执行数据库加载数据------------");
        return account;
    }
}