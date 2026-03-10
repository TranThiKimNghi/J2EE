package com.example.Lap05.config;

import com.example.Lap05.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AccountService accountService;

    // mã hóa password
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // cấu hình quyền
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth

                        // ADMIN
                        .requestMatchers("/products/add").hasRole("ADMIN")
                        .requestMatchers("/products/edit/**").hasRole("ADMIN")
                        .requestMatchers("/products/delete/**").hasRole("ADMIN")

                        // USER + ADMIN
                        .requestMatchers("/products/**").hasAnyRole("USER","ADMIN")

                        .anyRequest().authenticated()
                )

                // login mặc định
                .formLogin(login -> login
                        .defaultSuccessUrl("/products", true)
                );

        return http.build();
    }
}