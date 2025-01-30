package com.rmnlcn.REST_API_CRUD_employee.securities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails isabelle = User.builder()
                .username("isabelle")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails aurelie = User.builder()
                .username("aurelie")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails romain = User.builder()
                .username("romain")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails florian = User.builder()
                .username("florian")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(isabelle, aurelie, romain, florian);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/magic-api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/magic-api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/magic-api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/magic-api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/magic-api/employees/**").hasRole("ADMIN")
        );


        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
