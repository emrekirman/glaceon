package com.emrekirman.glaceon.gateway.external.inventory.model.transaction;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockResponse {
    private String id;
    private BigDecimal totalAmount;
    private BigDecimal totalPiece;
    private Integer productId;
    private String productName;
    private Integer unitId;
    private String unitName;
    private Integer count;
}
