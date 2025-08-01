package org.squidmin.java.spring.maven.springsession.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.squidmin.java.spring.maven.springsession.redis")
public class SpringSessionRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionRedisApplication.class, args);
    }

}
