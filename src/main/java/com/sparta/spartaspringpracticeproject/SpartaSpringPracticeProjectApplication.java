package com.sparta.spartaspringpracticeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpartaSpringPracticeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartaSpringPracticeProjectApplication.class, args);
    }

}
