package com.innovation.rentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan("com.innovation.rentcloud.model.rent")
@EnableEurekaClient
public class RentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RentServiceApplication.class, args);
    }
}
