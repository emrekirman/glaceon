package com.emrekirman.glaceon.inventory.transaction.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequest {

    @NotNull(message = "unit.price.not.valid")
    @Positive(message = "unit.price.not.valid")
    private BigDecimal unitPrice;

    @NotNull(message = "piece.not.valid")
    @Positive(message = "piece.not.valid")
    private BigDecimal piece;

    private BigDecimal discountRate;

    @NotNull(message = "product.not.valid")
    @Positive(message = "product.not.valid")
    private Integer productId;

    @NotNull(message = "unit.not.valid")
    @Positive(message = "unit.not.valid")
    private Integer unitId;

    @NotNull(message = "transaction.movement.not.valid")
    private TransactionMovement movement;
}
