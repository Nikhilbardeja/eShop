package com.example.eShop.Security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    @Order(1)
    public SecurityFilterChain adminFilterChain(HttpSecurity http,
            @Qualifier("adminDetailsServiceImpl") UserDetailsService adminService) throws Exception {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(adminService);
        authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // Uses the admin service

        http
                .securityMatcher("/admin/**") // This chain only handles /admin/** URLs
                .authenticationProvider(authProvider)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/login").permitAll() // Must allow access to login page
                        .anyRequest().hasRole("ADMIN") // Protect everything else under /admin/
                )
                .formLogin(login ->
                        login.loginPage("/admin/login")
                                .loginProcessingUrl("/admin/login")
                                .defaultSuccessUrl("/admin/test"))
                .logout(logout ->
                        logout.logoutUrl("/admin/logout")
                                .logoutSuccessUrl("/admin/test")
                                .deleteCookies("JSESSIONID"))
                
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain userFilterChain(HttpSecurity http,
            @Qualifier("userDetailsServiceImpl") UserDetailsService userService) throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userService);
        authProvider.setPasswordEncoder(passwordEncoder()); 

        http
                .securityMatcher("/user/**") // This chain only handles /user/** URLs
                .authenticationProvider(authProvider)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/login").permitAll() // Must allow access to login page
                        .anyRequest().hasRole("USER") // Protect everything else under /user/
                )
                .formLogin(login ->
                        login.loginPage("/user/login")
                                .loginProcessingUrl("/user/login")
                                .defaultSuccessUrl("/user/test"))
                .logout(logout ->
                        logout.logoutUrl("/user/logout")
                                .logoutSuccessUrl("/user/test")
                                .deleteCookies("JSESSIONID"))
                
                .csrf(csrf -> csrf.disable());

        return http.build();

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
