package com.gxitsky.Controller;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.gxitsky.dao.AccountDao;
import com.gxitsky.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @name: AccountController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-06 15:07
 **/
@RestController
@RequestMapping("/account")
public class AccountController {

//    @Autowired
    private LoadingCache<String, Account> loadingCache;

    @Autowired
    private AccountDao accountDao;

    @RequestMapping("/findById")
    public Account findById(String id) throws ExecutionException {
        if(loadingCache == null ){
            this.createLoadingCache();
        }

        Account account = loadingCache.get(id);
        ConcurrentMap<String, Account> accountConcurrentMap = loadingCache.asMap();
        System.out.println(JSON.toJSONString(accountConcurrentMap));
        return account;

    }

    public void createLoadingCache(){
        CacheLoader<String, Account> cacheLoader = new CacheLoader<String, Account>() {
            @Override
            public Account load(String key) throws Exception {
                System.out.println("缓存不存在,从数据库加载数据------------");
                return accountDao.findById(key);
            }
        };

        LoadingCache<String, Account> loadingCache = CacheBuilder.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .concurrencyLevel(10)
                .recordStats()
                .initialCapacity(10000)
                .maximumSize(10000)
                .build(cacheLoader);
        this.loadingCache = loadingCache;
    }
}