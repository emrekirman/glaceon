package com.emrekirman.glaceon.gateway.external.inventory.model.transaction;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequest {
    private BigDecimal unitPrice;
    private BigDecimal piece;
    private BigDecimal discountRate;
    private Integer productId;
    private Integer unitId;
    private TransactionMovement movement;
}
