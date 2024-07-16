package com.emrekirman.glaceon.inventory.transaction.entity;

import com.emrekirman.glaceon.inventory.common.entity.BaseEntity;
import com.emrekirman.glaceon.inventory.product.entity.Product;
import com.emrekirman.glaceon.inventory.transaction.model.TransactionMovement;
import com.emrekirman.glaceon.inventory.unit.entity.Unit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_transaction")
public class Transaction extends BaseEntity {

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column
    private BigDecimal piece;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "discount_rate")
    private BigDecimal discountRate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @Column
    private TransactionMovement movement;
}
