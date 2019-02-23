package com.springcloud.sakilaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SakilaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SakilaServiceApplication.class, args);
//        new SpringApplicationBuilder(SakilaServiceApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
