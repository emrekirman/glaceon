package com.emrekirman.glaceon.inventory.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseDefinitionEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String code;

    public static <T extends BaseDefinitionEntity> void prepareCode(T entity) {
        entity.setCode(entity.getName().replace(" ", "_").toUpperCase().toLowerCase());
    }
}