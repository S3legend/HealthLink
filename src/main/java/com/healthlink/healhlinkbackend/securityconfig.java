package com.healthlink.healhlinkbackend;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/api/auth/**", "/api/users/register").permitAll() // Autoriser l'accès à tous les endpoints d'authentification
                .anyRequest().permitAll(); // Exiger une authentification pour toutes les autres requêtes

        return http.build();
    }
}
