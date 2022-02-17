package com.gxitsky;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class ShardingTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingTableApplication.class, args);
    }

}
