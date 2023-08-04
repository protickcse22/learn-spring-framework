package com.protick.learnspringsecurity.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTAuthenticationResource {

    @PostMapping("/authenticate")
    public Authentication authentication(Authentication authentication) {
        return authentication;
    }
}
