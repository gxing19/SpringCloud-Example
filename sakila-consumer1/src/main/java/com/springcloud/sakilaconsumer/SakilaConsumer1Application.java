package com.springcloud.sakilaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class SakilaConsumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(SakilaConsumer1Application.class, args);
    }
}
