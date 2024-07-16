package com.emrekirman.glaceon.gateway.external.inventory.model.product;

import lombok.Data;

import java.util.Date;

@Data
public class ProductUpdateRequest {

    private Integer id;
    private String createdUser;
    private Date createdDate;
    private String name;
    private String code;
}
