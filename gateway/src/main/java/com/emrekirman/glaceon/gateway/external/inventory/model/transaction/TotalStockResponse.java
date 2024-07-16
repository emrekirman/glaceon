package com.emrekirman.glaceon.gateway.external.inventory.model.transaction;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
public class TotalStockResponse {
    private List<StockResponse> stockList;
    private BigDecimal totalAmount;
}
