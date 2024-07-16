package com.emrekirman.glaceon.inventory.unit.entity;

import com.emrekirman.glaceon.inventory.common.entity.BaseDefinitionEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Where;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_unit")
@Where(clause = "deleted_date is null")
public class Unit extends BaseDefinitionEntity {
}
