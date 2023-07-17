package com.protick.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = createNewUser("protick", "12345");
        UserDetails userDetails2 = createNewUser("prionti", "12345");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String userName, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        return User.builder()
                .passwordEncoder(passwordEncoder)
                .username(userName)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        httpSecurity.formLogin(Customizer.withDefaults());
        Customizer<CsrfConfigurer<HttpSecurity>> csrfDisable = AbstractHttpConfigurer::disable;
        httpSecurity.csrf(csrfDisable);
        Customizer<HeadersConfigurer<HttpSecurity>> frameOption = AbstractHttpConfigurer::disable;
        httpSecurity.headers(frameOption);

        return httpSecurity.build();
    }

}
