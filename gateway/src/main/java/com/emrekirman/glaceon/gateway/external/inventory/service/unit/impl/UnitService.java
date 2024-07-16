package com.emrekirman.glaceon.gateway.external.inventory.service.unit.impl;

import com.emrekirman.glaceon.gateway.common.external.util.ExternalApiHeaderUtil;
import com.emrekirman.glaceon.gateway.external.inventory.model.unit.UnitRequest;
import com.emrekirman.glaceon.gateway.external.inventory.model.unit.UnitResponse;
import com.emrekirman.glaceon.gateway.external.inventory.model.unit.UnitUpdateRequest;
import com.emrekirman.glaceon.gateway.external.inventory.service.unit.IUnitService;
import com.emrekirman.glaceon.gateway.systemParameter.service.SystemParameterService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UnitService implements IUnitService {
    private final RestTemplate restTemplate;
    private final SystemParameterService systemParameterService;

    private static String BASE_URL = "";
    private final static String BASE_URL_CODE = "inventory.service.url";

    public UnitService(
            @Qualifier("inventoryServiceRestTemplate") RestTemplate restTemplate,
            SystemParameterService systemParameterService) {
        this.restTemplate = restTemplate;
        this.systemParameterService = systemParameterService;
    }

    @Override
    public UnitResponse create(UnitRequest unitRequest) {

        ResponseEntity<UnitResponse> responseEntity = restTemplate
                .exchange(BASE_URL + "/api/v1/units",
                        HttpMethod.POST,
                        new HttpEntity<>(unitRequest, ExternalApiHeaderUtil.getRequestHeader()),
                        UnitResponse.class);

        log.info("Unit created. request : {}", unitRequest);

        return responseEntity.getBody();

    }

    @Override
    public UnitResponse update(UnitUpdateRequest unitRequest) {

        ResponseEntity<UnitResponse> responseEntity = restTemplate
                .exchange(BASE_URL + "/api/v1/units",
                        HttpMethod.PUT,
                        new HttpEntity<>(unitRequest, ExternalApiHeaderUtil.getRequestHeader()),
                        UnitResponse.class);

        log.info("Unit updated. request : {}", unitRequest);

        return responseEntity.getBody();

    }

    @Override
    public List<UnitResponse> findAll() {

        ResponseEntity<UnitResponse[]> responseEntity = restTemplate
                .exchange(BASE_URL + "/api/v1/units",
                        HttpMethod.GET,
                        new HttpEntity<>(null, ExternalApiHeaderUtil.getRequestHeader()),
                        UnitResponse[].class);

        return List.of(responseEntity.getBody());

    }

    @Override
    public UnitResponse findById(Integer id) {

        ResponseEntity<UnitResponse> responseEntity = restTemplate
                .exchange(BASE_URL + "/api/v1/units/" + id,
                        HttpMethod.GET,
                        new HttpEntity<>(null, ExternalApiHeaderUtil.getRequestHeader()),
                        UnitResponse.class);

        return responseEntity.getBody();

    }

    @PostConstruct
    void construct() {
        BASE_URL = systemParameterService.getValueByCode(BASE_URL_CODE);
    }
}
