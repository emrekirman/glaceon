package com.emrekirman.glaceon.gateway.external.inventory.service.transaction.impl;

import com.emrekirman.glaceon.gateway.common.external.util.ExternalApiHeaderUtil;
import com.emrekirman.glaceon.gateway.external.inventory.model.transaction.TotalStockResponse;
import com.emrekirman.glaceon.gateway.external.inventory.model.transaction.TransactionRequest;
import com.emrekirman.glaceon.gateway.external.inventory.model.transaction.TransactionResponse;
import com.emrekirman.glaceon.gateway.external.inventory.service.transaction.ITransactionService;
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
public class TransactionService implements ITransactionService {
    private final RestTemplate restTemplate;
    private final SystemParameterService systemParameterService;

    private static String BASE_URL = "";
    private final static String BASE_URL_CODE = "inventory.service.url";

    public TransactionService(
            @Qualifier("inventoryServiceRestTemplate") RestTemplate restTemplate,
            SystemParameterService systemParameterService) {
        this.restTemplate = restTemplate;
        this.systemParameterService = systemParameterService;
    }

    @Override
    public TransactionResponse create(TransactionRequest transactionRequest) {

        ResponseEntity<TransactionResponse> responseEntity = restTemplate
                .exchange(BASE_URL + "/api/v1/transactions",
                        HttpMethod.POST,
                        new HttpEntity<>(transactionRequest, ExternalApiHeaderUtil.getRequestHeader()),
                        TransactionResponse.class);

        log.info("Transaction created. request : {}", transactionRequest);

        return responseEntity.getBody();

    }

    @Override
    public TotalStockResponse getStockByProductId(Integer productId) {

        ResponseEntity<TotalStockResponse> responseEntity = restTemplate
                .exchange(BASE_URL + "/api/v1/transactions/stocks/by-product/" + productId,
                        HttpMethod.GET,
                        new HttpEntity<>(null, ExternalApiHeaderUtil.getRequestHeader()),
                        TotalStockResponse.class);

        log.info("Stocks fetched. productId : {}", productId);

        return responseEntity.getBody();

    }

    @PostConstruct
    void construct() {
        BASE_URL = systemParameterService.getValueByCode(BASE_URL_CODE);
    }
}
