package com.example.personalfinancemiddleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FinanceMiddlewareApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceMiddlewareApplication.class, args);
    }
}
