package com.healthlink.consultation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Désactive CSRF pour les tests (ne pas faire en production)
                .authorizeHttpRequests()
                .requestMatchers("/api/consultations/**").permitAll() // Autorise les requêtes sans authentification
                .anyRequest().authenticated(); // Protège les autres endpoints
        return http.build();
    }
}
