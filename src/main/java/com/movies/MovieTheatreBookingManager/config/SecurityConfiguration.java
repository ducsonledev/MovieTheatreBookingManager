package com.movies.MovieTheatreBookingManager.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**", "/api/v1/**")// represents application patterns // for testing purpose we allow "/api/v1/**" for now, later remove it
                .permitAll() // whitelist request matchers
                .anyRequest() // all other requests
                .authenticated() // should be authenticated
                .and() // session manager once per request filter, every request should be authenticated, authentication session should be stateless to ensure each will be authenticated
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider) // bean
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); //  check before jwt token

        return http.build();
    }
}
