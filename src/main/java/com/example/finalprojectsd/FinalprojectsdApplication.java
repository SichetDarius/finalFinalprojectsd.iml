package com.example.finalprojectsd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude={
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
public class FinalprojectsdApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalprojectsdApplication.class, args);
    }

}
