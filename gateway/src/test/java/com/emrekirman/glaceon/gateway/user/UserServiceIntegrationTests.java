package com.emrekirman.glaceon.gateway.user;

import com.emrekirman.glaceon.gateway.external.user.model.UserResponse;
import com.emrekirman.glaceon.gateway.external.user.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceIntegrationTests {

    @Autowired
    IUserService userService;


    @Test
    void findByUsername() {
        UserResponse testuser = userService.findByUsername("testuser");

        System.out.println("user : " + testuser);
    }
}
