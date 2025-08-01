package org.squidmin.java.spring.maven.springsession.jdbc.postgres;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Slf4j
public class ActuatorTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void health() {
        ResponseEntity<String> response = restTemplate.withBasicAuth("user", "user")
            .getForEntity(
                "http://localhost:" + port + "/actuator/health",
                String.class
            );
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void info() {
        ResponseEntity<String> response = restTemplate.withBasicAuth("user", "user")
            .getForEntity(
                "http://localhost:" + port + "/actuator/info",
                String.class
            );
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
