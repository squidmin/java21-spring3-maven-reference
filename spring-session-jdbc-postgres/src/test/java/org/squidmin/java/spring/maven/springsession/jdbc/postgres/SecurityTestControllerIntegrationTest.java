package org.squidmin.java.spring.maven.springsession.jdbc.postgres;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.squidmin.java.spring.maven.springsession.jdbc.postgres.controller.SecurityTestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SecurityTestController.class)
@ContextConfiguration(classes = {
    SpringSessionJdbcPostgresApplication.class,
    SecurityConfig.class,
    CustomUserDetailsService.class})
public class SecurityTestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = {"INVALID"})
    void accountSummary_with_invalid_role_should_return_403() throws Exception {
        mockMvc.perform(get("/security-test")).andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = {"SUPERADMIN"})
    void securityTest() throws Exception {
        mockMvc.perform(get("/security-test")).andExpect(status().isOk());
    }

}
