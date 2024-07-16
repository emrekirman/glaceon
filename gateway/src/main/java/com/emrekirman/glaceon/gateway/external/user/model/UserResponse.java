package com.emrekirman.glaceon.gateway.external.user.model;

import lombok.Data;

@Data
public class UserResponse {
    private Integer id;
    private String username;
    private String password;
}