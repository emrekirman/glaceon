package com.emrekirman.glaceon.gateway.auth;

import com.emrekirman.glaceon.gateway.auth.model.LoginRequest;
import com.emrekirman.glaceon.gateway.auth.service.AuthService;
import com.emrekirman.glaceon.gateway.common.model.LoginResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthTests {
    @Autowired
    AuthService authService;


    @Test
    void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("testuser");
        loginRequest.setPassword("123456");

        LoginResponse auth = authService.auth(loginRequest);

        System.out.println("token : " + auth.getToken());
    }
}
