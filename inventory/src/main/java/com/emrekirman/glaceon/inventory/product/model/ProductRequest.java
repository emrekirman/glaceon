package com.emrekirman.glaceon.inventory.product.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {

    @NotNull(message = "name.not.valid")
    @NotEmpty(message = "name.not.valid")
    @NotBlank(message = "name.not.valid")
    private String name;
}
