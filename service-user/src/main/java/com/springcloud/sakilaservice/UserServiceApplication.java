package com.springcloud.sakilaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
//        new SpringApplicationBuilder(UserServiceApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
