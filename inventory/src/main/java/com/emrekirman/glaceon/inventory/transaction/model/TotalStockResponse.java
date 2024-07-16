package com.emrekirman.glaceon.inventory.transaction.model;

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
