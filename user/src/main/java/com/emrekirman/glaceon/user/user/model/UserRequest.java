package com.emrekirman.glaceon.user.user.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequest {

    @NotNull(message = "username.not.valid")
    @NotEmpty(message = "username.not.valid")
    @NotBlank(message = "username.not.valid")
    private String username;

    @NotNull(message = "password.not.valid")
    @NotEmpty(message = "password.not.valid")
    @NotBlank(message = "password.not.valid")
    private String password;
}
