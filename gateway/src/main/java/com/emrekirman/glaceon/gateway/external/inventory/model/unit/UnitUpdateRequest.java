package com.emrekirman.glaceon.gateway.external.inventory.model.unit;

import lombok.Data;

import java.util.Date;

@Data
public class UnitUpdateRequest {
    private Integer id;
    private String createdUser;
    private Date createdDate;
    private String name;
    private String code;
}
