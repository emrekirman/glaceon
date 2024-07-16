package com.emrekirman.glaceon.gateway.common.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_date")
    private Date createdDate = new Date();
    @Column(name = "created_user")
    private String createdUser;
    @Column(name = "updated_date")
    private Date updatedDate;
    @Column(name = "updated_user")
    private String updatedUser;
    @Column(name = "deleted_date")
    private Date deletedDate;
    @Column(name = "deleted_user")
    private String deletedUser;
}