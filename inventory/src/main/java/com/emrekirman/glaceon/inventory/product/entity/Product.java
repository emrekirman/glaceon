package com.emrekirman.glaceon.inventory.product.entity;

import com.emrekirman.glaceon.inventory.common.entity.BaseDefinitionEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Where;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_product")
@Where(clause = "deleted_date is null")
public class Product extends BaseDefinitionEntity {

}
