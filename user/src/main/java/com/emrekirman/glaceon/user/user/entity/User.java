package com.emrekirman.glaceon.user.user.entity;

import com.emrekirman.glaceon.user.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_user")
@Data
public class User extends BaseEntity {

    @Column
    private String username;

    @Column
    private String password;
}
