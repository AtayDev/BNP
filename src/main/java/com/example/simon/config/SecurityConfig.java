package com.example.simon.config;

import jakarta.servlet.http.HttpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //Create users in Memory
    @Bean
    public InMemoryUserDetailsManager addUsersInMemory(){
        UserDetails john = User.builder()
                .username("John")
                .password("{noop}123")
                .roles("ADMIN")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}123")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(john, susan);
    }


    @Bean
    public SecurityFilterChain addFilters(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/api/v1/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/transactions").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/v1/users").hasRole("EMPLOYEE")
                        .anyRequest().authenticated()
                ).sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ).httpBasic(Customizer.withDefaults());  // This is the correct way


        return http.build();
    }
}
