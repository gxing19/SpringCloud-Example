package com.springcloud.service.consumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerService1Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerService1Application.class, args);
    }
}
