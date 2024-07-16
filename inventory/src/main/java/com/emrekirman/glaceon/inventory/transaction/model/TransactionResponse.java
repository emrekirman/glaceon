package com.emrekirman.glaceon.inventory.transaction.model;

import com.emrekirman.glaceon.inventory.common.model.BaseResponse;
import com.emrekirman.glaceon.inventory.product.model.ProductResponse;
import com.emrekirman.glaceon.inventory.unit.model.UnitResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class TransactionResponse extends BaseResponse {
    private BigDecimal unitPrice;
    private BigDecimal piece;
    private BigDecimal discountedUnitPrice;
    private BigDecimal totalAmount;
    private BigDecimal discountRate;
    private ProductResponse product;
    private UnitResponse unit;
}
