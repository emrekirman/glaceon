package com.emrekirman.glaceon.inventory.unit.model;

import com.emrekirman.glaceon.inventory.common.model.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UnitResponse extends BaseResponse {
    private String name;
    private String code;
}
