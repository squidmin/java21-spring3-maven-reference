package org.squidmin.java.spring.maven.springsession.jdbc.postgres;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
@Primary
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User.UserBuilder builder = User.builder();
        builder.username(username);
        builder.password(passwordEncoder.encode(username));

        switch (username) {
            case "james" -> builder.roles("USER", "SUPERADMIN");
            case "testuser" -> builder.roles("USER");
            case "guest" -> builder.roles("USER", "ADMIN");
            default -> throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }

}
