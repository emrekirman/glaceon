package com.emrekirman.glaceon.gateway.systemParameter.entity;

import com.emrekirman.glaceon.gateway.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_system_parameter")
public class SystemParameter extends BaseEntity {

    @Column
    private String code;

    @Column
    private String value;

    @Column
    private String description;
}
