package com.emrekirman.glaceon.gateway.external.inventory.model.transaction;

import com.emrekirman.glaceon.gateway.common.model.BaseResponse;
import com.emrekirman.glaceon.gateway.external.inventory.model.product.ProductResponse;
import com.emrekirman.glaceon.gateway.external.inventory.model.unit.UnitResponse;
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
