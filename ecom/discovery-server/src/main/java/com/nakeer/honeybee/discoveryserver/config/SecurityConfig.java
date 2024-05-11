package com.nakeer.honeybee.discoveryserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // Other configurations...
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/eureka/**").permitAll()
                                .anyRequest().authenticated()
                )
        // Add other security configurations as needed
        ;

        // Apply custom CSRF configuration
        httpSecurity
                .csrf(csrf -> csrf
                                .ignoringRequestMatchers("/eureka/**") // Ignore CSRF for /eureka/**
                        // Other CSRF configurations if needed
                );

        return httpSecurity.build();
    }
}