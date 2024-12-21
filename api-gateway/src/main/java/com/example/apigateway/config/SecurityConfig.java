package com.example.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity
                .authorizeExchange(exchange -> exchange
                        // Public GET endpoints
                        .pathMatchers(HttpMethod.GET, "/clients").permitAll()
                        .pathMatchers(HttpMethod.GET, "/motorbikes").permitAll()
                        .pathMatchers(HttpMethod.GET, "/reservations").permitAll()

                        // Authenticated POST endpoints
                        .pathMatchers(HttpMethod.POST, "/clients").authenticated()
                        .pathMatchers(HttpMethod.POST, "/motorbikes").authenticated()
                        .pathMatchers(HttpMethod.POST, "/reservations").authenticated()

                        // Authenticated DELETE endpoints
                        .pathMatchers(HttpMethod.DELETE, "/clients/**").authenticated()
                        .pathMatchers(HttpMethod.DELETE, "/motorbikes/**").authenticated()
                        .pathMatchers(HttpMethod.DELETE, "/reservations/**").authenticated()

                        // Catch-all for other methods to ensure authenticated access
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()));

        return serverHttpSecurity.build();
    }
}
