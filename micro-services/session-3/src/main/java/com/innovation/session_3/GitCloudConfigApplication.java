package com.innovation.session_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class GitCloudConfigApplication {
    public static void main(String[] args) {
        // URL-> http://localhost:8191/membership/dev
        //http://localhost:8191/membership-dev.yml
        //http://localhost:8191/membership-dev.properties
        SpringApplication.run(GitCloudConfigApplication.class, args);
    }
}
