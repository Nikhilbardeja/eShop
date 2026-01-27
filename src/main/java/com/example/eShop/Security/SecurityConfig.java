package com.example.eShop.Security;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    @Order(1)
    public SecurityFilterChain adminFilterChain(HttpSecurity http, @Qualifier("adminDetailsServiceImpl") UserDetailsService adminService) throws Exception{

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(adminService);
        authProvider.setPasswordEncoder(passwordEncoder()); // Uses the admin service

        http
            .securityMatcher("/admin/**")
            .authenticationProvider(authProvider)
            .formLogin(form -> form.loginPage("/admin/login"))
            // .authorizeHttpRequests(auth-> auth
            //     .anyRequest().permitAll()
            // )
            .csrf(csrf->csrf.disable());
            

        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain userFilterChain(HttpSecurity http, @Qualifier("userDetailsServiceImpl") UserDetailsService userService) throws Exception{
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userService);
        authProvider.setPasswordEncoder(passwordEncoder()); // Uses the admin service

        http
            .authenticationProvider(authProvider)
            .formLogin(form -> form.loginPage("/user/login"))
            // .authorizeHttpRequests(auth-> auth
            //     .anyRequest().permitAll()
            // )
            .csrf(csrf->csrf.disable());
            

        return http.build();

    }



    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
