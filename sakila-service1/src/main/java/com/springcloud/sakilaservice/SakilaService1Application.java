package com.springcloud.sakilaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SakilaService1Application {

    public static void main(String[] args) {
        SpringApplication.run(SakilaService1Application.class, args);
//        new SpringApplicationBuilder(SakilaServiceApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
