package org.squidmin.java.spring.maven.springsession.jdbc.postgres.dto;

public class SecurityTestResponse {

    private String message;

    public SecurityTestResponse() {
    }

    public SecurityTestResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
