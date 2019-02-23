package com.springcloud.sakilaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SakilaServiceApplication1 {
    
    public static void main(String[] args) {
        SpringApplication.run(SakilaServiceApplication1.class, args);
//        new SpringApplicationBuilder(SakilaServiceApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
