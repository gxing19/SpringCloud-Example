package com.gxitsky;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableScheduling
@EnableSwagger2Doc
public class ConsumerService1Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerService1Application.class, args);
    }
}
