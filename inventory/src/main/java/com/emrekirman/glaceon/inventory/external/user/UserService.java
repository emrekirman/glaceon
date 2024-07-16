package com.emrekirman.glaceon.inventory.external.user;

import com.emrekirman.glaceon.inventory.systemParameter.service.SystemParameterService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final RestTemplate restTemplate;
    private final SystemParameterService systemParameterService;

    private static String BASE_URL = "";
    private final static String BASE_URL_CODE = "user.service.url";

    public UserService(@Qualifier("userApiRestTemplate") RestTemplate restTemplate, SystemParameterService systemParameterService) {
        this.restTemplate = restTemplate;
        this.systemParameterService = systemParameterService;
    }

    public boolean existUsernameAndPassword(String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        Boolean responseEntity = restTemplate.getForObject(
                BASE_URL + "/api/v1/users/exists?username={username}&password={password}",
                Boolean.class,
                params
        );

        return Boolean.TRUE.equals(responseEntity);
    }

    @PostConstruct
    void construct() {
        BASE_URL = systemParameterService.getValueByCode(BASE_URL_CODE);
    }
}
