package com.emrekirman.glaceon.user.common.entity;

import com.emrekirman.glaceon.user.common.security.CustomUserDetails;
import com.emrekirman.glaceon.user.common.security.SessionInformation;
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

    public static <T extends BaseEntity> void setCreateAudit(T entity) {
        CustomUserDetails user = SessionInformation.getUser();

        entity.setCreatedDate(new Date());
        if (user != null) {
            entity.setCreatedUser(user.getUsername());
        }
    }

    public static <T extends BaseEntity> void setUpdateAudit(T entity) {
        CustomUserDetails user = SessionInformation.getUser();

        entity.setUpdatedDate(new Date());
        if (user != null) {
            entity.setUpdatedUser(user.getUsername());
        }
    }

    public static <T extends BaseEntity> void setDeleteAudit(T entity) {
        CustomUserDetails user = SessionInformation.getUser();

        entity.setDeletedDate(new Date());
        if (user != null) {
            entity.setDeletedUser(user.getUsername());
        }
    }
}