package org.squidmin.java.spring.maven.springappboilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.squidmin.java.spring.maven.springappboilerplate")
public class SpringAppBoilerplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAppBoilerplateApplication.class, args);
    }

}
