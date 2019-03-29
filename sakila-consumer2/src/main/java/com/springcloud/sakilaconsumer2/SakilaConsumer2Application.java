package com.springcloud.sakilaconsumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableHystrix
@SpringBootApplication
public class SakilaConsumer2Application {

    public static void main(String[] args) {
        SpringApplication.run(SakilaConsumer2Application.class, args);
    }

}
