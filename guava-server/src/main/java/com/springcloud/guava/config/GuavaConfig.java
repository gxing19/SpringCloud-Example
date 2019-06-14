package com.springcloud.guava.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.springcloud.guava.dao.AccountDao;
import com.springcloud.guava.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @name: GuavaConfig
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-06 11:06
 **/
@Configuration
public class GuavaConfig {

    @Autowired
    private AccountDao accountDao;

    /*public GuavaConfig() {
    }*/

    /*public GuavaConfig(AccountDao accountDao) {
        this.accountDao = accountDao;
    }*/

    @Bean
    public LoadingCache<String, Account> loadingCache() {

        //缓存加载器
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

        return loadingCache;
    }
}
