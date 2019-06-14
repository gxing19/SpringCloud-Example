package com.springcloud.guava.dao;

import com.springcloud.guava.entity.Account;

/**
 * @name: AccountDao
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-06 16:06
 **/
public interface AccountDao {
    Account findById(String id);
}