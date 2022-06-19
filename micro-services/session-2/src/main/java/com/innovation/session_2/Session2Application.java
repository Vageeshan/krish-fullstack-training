package com.innovation.session_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Session2Application {
    public static void main(String[] args) {
        //externalise config in local
        SpringApplication.run(Session2Application.class, args);
        //URL http://localhost:8191/service2/default
        //URL http://localhost:8191/service1/default
    }
}
