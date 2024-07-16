package com.emrekirman.glaceon.gateway.external.inventory.model.product;

import com.emrekirman.glaceon.gateway.common.model.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductResponse extends BaseResponse {
    private String name;
    private String code;
}
