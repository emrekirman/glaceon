package com.emrekirman.glaceon.user.apiKeyGenerate;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Base64;

public class ApiKeyGeneratorTests {


    @Test
    void generateApiKeyUser() throws JsonProcessingException {
        UserDetails userDetails =
                new User("testuser", "$2a$10$chCrZNV8LlMODShZkBAkh.thcrwjM7pSPmcv1ycM7XQygBoUd27Lm", new ArrayList<>());

        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(userDetails);

        String encoded = Base64.getEncoder().encodeToString(value.getBytes());

        System.out.println("encoded : " + encoded);
    }
}
