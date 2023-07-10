package com.protick.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean isAuthenticate(String name, String password) {
        boolean isValidUserName = name.equalsIgnoreCase("protick");
        boolean isValidPassword = password.equalsIgnoreCase("12345");

        return isValidUserName && isValidPassword;
    }
}
