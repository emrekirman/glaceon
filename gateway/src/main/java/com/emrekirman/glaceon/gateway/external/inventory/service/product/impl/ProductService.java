package com.emrekirman.glaceon.gateway.external.inventory.service.product.impl;

import com.emrekirman.glaceon.gateway.common.external.util.ExternalApiHeaderUtil;
import com.emrekirman.glaceon.gateway.external.inventory.model.product.ProductRequest;
import com.emrekirman.glaceon.gateway.external.inventory.model.product.ProductResponse;
import com.emrekirman.glaceon.gateway.external.inventory.model.product.ProductUpdateRequest;
import com.emrekirman.glaceon.gateway.external.inventory.service.product.IProductService;
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
public class ProductService implements IProductService {
    private final RestTemplate restTemplate;
    private final SystemParameterService systemParameterService;

    private static String BASE_URL = "";
    private final static String BASE_URL_CODE = "inventory.service.url";

    public ProductService(
            @Qualifier("inventoryServiceRestTemplate") RestTemplate restTemplate,
            SystemParameterService systemParameterService) {
        this.restTemplate = restTemplate;
        this.systemParameterService = systemParameterService;
    }

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        log.info("Product create request start. request : {}", productRequest);

        ResponseEntity<ProductResponse> responseEntity = restTemplate
                .exchange(BASE_URL + "/api/v1/products",
                        HttpMethod.POST,
                        new HttpEntity<>(productRequest, ExternalApiHeaderUtil.getRequestHeader()),
                        ProductResponse.class);

        log.info("Product create request response success. request : {}", productRequest);

        return responseEntity.getBody();
    }

    @Override
    public ProductResponse update(ProductUpdateRequest productUpdateRequest) {
        log.info("Product update start. request : {}", productUpdateRequest);

        ResponseEntity<ProductResponse> responseEntity = restTemplate
                .exchange(BASE_URL + "/api/v1/products",
                        HttpMethod.PUT,
                        new HttpEntity<>(productUpdateRequest, ExternalApiHeaderUtil.getRequestHeader()),
                        ProductResponse.class);

        log.info("Product update request response success. request : {}", productUpdateRequest);

        return responseEntity.getBody();

    }

    @Override
    public void deleteById(Integer id) {

        restTemplate
                .exchange(BASE_URL + "/api/v1/products/" + id,
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, ExternalApiHeaderUtil.getRequestHeader()),
                        Void.class);

        log.info("Product deleted. productId : {}", id);
    }

    @Override
    public List<ProductResponse> findAll() {

        ResponseEntity<ProductResponse[]> responseEntity = restTemplate
                .exchange(BASE_URL + "/api/v1/products",
                        HttpMethod.GET,
                        new HttpEntity<>(null, ExternalApiHeaderUtil.getRequestHeader()),
                        ProductResponse[].class);

        return List.of(responseEntity.getBody());

    }

    @Override
    public ProductResponse findById(Integer id) {

        ResponseEntity<ProductResponse> responseEntity = restTemplate
                .exchange(BASE_URL + "/api/v1/products/" + id,
                        HttpMethod.GET,
                        new HttpEntity<>(null, ExternalApiHeaderUtil.getRequestHeader()),
                        ProductResponse.class);

        return responseEntity.getBody();

    }

    @PostConstruct
    void construct() {
        BASE_URL = systemParameterService.getValueByCode(BASE_URL_CODE);
    }
}
