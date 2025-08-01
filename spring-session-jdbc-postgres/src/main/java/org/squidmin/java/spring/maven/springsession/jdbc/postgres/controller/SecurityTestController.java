package org.squidmin.java.spring.maven.springsession.jdbc.postgres.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.squidmin.java.spring.maven.springsession.jdbc.postgres.dto.SecurityTestResponse;

import java.security.Principal;

@RestController
@RequestMapping("/security-test")
public class SecurityTestController {

    /**
     * Endpoint to test security context and return the authenticated user's name.
     * If no user is authenticated, it returns a 401 Unauthorized response.
     *
     * @param principal the authenticated user's principal
     * @return ResponseEntity with security test result
     */
    @GetMapping
    public ResponseEntity<SecurityTestResponse> securityTest(Principal principal) {
        if (principal != null) {
            return ResponseEntity.ok(new SecurityTestResponse("Security test passed for user: " + principal.getName()));
        } else {
            return ResponseEntity.status(401)
                .body(new SecurityTestResponse("Security test failed: No authenticated user found"));
        }
    }

    /**
     * Endpoint to check the authenticated user's identity.
     * Returns a 401 Unauthorized response if no user is authenticated.
     *
     * @param principal the authenticated user's principal
     * @return ResponseEntity with the authenticated user's name or an error message
     */
    @GetMapping("/whoami")
    public ResponseEntity<SecurityTestResponse> whoami(Principal principal) {
        if (principal != null) {
            return ResponseEntity.ok(new SecurityTestResponse("Authenticated user: " + principal.getName()));
        } else {
            return ResponseEntity.status(401).body(new SecurityTestResponse("No authenticated user found"));
        }
    }

}
