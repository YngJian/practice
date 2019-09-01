package com.example.hui_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HuiPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuiPracticeApplication.class, args);
    }

}
