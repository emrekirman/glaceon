package com.emrekirman.glaceon.gateway.external.user.model;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
}
