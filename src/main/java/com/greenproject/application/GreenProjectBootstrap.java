package com.greenproject.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan({"com.greenproject.configuration"})
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
