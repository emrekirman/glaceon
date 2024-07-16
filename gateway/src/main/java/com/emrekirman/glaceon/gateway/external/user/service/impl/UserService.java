package com.emrekirman.glaceon.gateway.external.user.service.impl;

import com.emrekirman.glaceon.gateway.common.external.util.ExternalApiHeaderUtil;
import com.emrekirman.glaceon.gateway.external.user.model.UserRequest;
import com.emrekirman.glaceon.gateway.external.user.model.UserResponse;
import com.emrekirman.glaceon.gateway.external.user.service.IUserService;
import com.emrekirman.glaceon.gateway.systemParameter.service.SystemParameterService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService implements IUserService {
    private final RestTemplate restTemplate;
    private final SystemParameterService systemParameterService;

    private static String BASE_URL = "";
    private final static String BASE_URL_CODE = "user.service.url";

    public UserService(
            @Qualifier("userServiceRestTemplate") RestTemplate restTemplate, SystemParameterService systemParameterService) {
        this.restTemplate = restTemplate;
        this.systemParameterService = systemParameterService;
    }

    @Override
    public UserResponse findByUsername(String username) {
        ResponseEntity<UserResponse> forEntity =
                restTemplate.getForEntity(BASE_URL + "/api/v1/users/by-username/" + username, UserResponse.class);

        return forEntity.getBody();
    }


    @Override
    public UserResponse create(UserRequest userRequest) {
        HttpEntity<UserRequest> http = new HttpEntity<UserRequest>(userRequest, ExternalApiHeaderUtil.getRequestHeader());

        ResponseEntity<UserResponse> responseEntity =
                restTemplate.exchange(BASE_URL + "/api/v1/users", HttpMethod.POST, http, UserResponse.class);

        log.info("User created. request : {}", userRequest);

        return responseEntity.getBody();
    }


    @PostConstruct
    void construct() {
        BASE_URL = systemParameterService.getValueByCode(BASE_URL_CODE);
    }
}
