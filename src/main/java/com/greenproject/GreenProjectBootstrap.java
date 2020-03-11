package com.greenproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.greenproject")
@EnableScheduling
public class GreenProjectBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(GreenProjectBootstrap.class, args);
    }

    @RestController
    public class Status {
        @RequestMapping("/status")
        public String status() {
            return "ok";
        }
    }
}
    