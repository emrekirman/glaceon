package com.emrekirman.glaceon.inventory.product.model;

import com.emrekirman.glaceon.inventory.common.model.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductResponse extends BaseResponse {
    private String name;
    private String code;
}
