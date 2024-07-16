package com.emrekirman.glaceon.inventory.common.model;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseResponse {
    private Integer id;
    private String createdUser;
    private Date createdDate;
    private String updatedUser;
    private Date updatedDate;
}