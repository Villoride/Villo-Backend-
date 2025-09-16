package com.villo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync

public class VilloApplication {
    public static void main(String[] args) {
        SpringApplication.run(VilloApplication.class, args);
    }
}
