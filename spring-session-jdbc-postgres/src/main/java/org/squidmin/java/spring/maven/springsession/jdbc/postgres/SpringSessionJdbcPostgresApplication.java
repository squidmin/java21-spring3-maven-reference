package org.squidmin.java.spring.maven.springsession.jdbc.postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "org.squidmin.java.spring.maven.springsession.jdbc.postgres")
@Import(SecurityConfig.class)
public class SpringSessionJdbcPostgresApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionJdbcPostgresApplication.class, args);
    }

}
