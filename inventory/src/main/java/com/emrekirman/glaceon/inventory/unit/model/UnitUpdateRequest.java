package com.emrekirman.glaceon.inventory.unit.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;

@Data
public class UnitUpdateRequest {
    @NotNull(message = "id.field.not.valid")
    @Positive(message = "id.field.not.valid")
    private Integer id;
    private String createdUser;
    private Date createdDate;
    @NotNull(message = "name.not.valid")
    @NotEmpty(message = "name.not.valid")
    @NotBlank(message = "name.not.valid")
    private String name;
    private String code;
}
