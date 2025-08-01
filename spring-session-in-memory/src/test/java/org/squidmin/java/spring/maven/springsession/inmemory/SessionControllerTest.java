package org.squidmin.java.spring.maven.springsession.inmemory;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Slf4j
public class SessionControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate rest;

    @Test
    void sessionShouldIncrementAcrossRequests() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.COOKIE, "");

        ResponseEntity<String> r1 = rest.exchange("/session/increment", HttpMethod.GET, new HttpEntity<>(headers), String.class);
        String cookie = r1.getHeaders().getFirst(HttpHeaders.SET_COOKIE);

        HttpHeaders reusedHeaders = new HttpHeaders();
        reusedHeaders.add(HttpHeaders.COOKIE, cookie);
        ResponseEntity<String> r2 = rest.exchange("/session/increment", HttpMethod.GET, new HttpEntity<>(reusedHeaders), String.class);

        assertThat(r1.getBody()).contains("1");
        assertThat(r2.getBody()).contains("2");
    }

}
