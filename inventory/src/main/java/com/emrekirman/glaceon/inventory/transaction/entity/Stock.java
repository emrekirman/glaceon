package com.emrekirman.glaceon.inventory.transaction.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

@Entity
@Table(name = "total_stock_view_product_and_unit")
@Immutable
@Data
public class Stock {
    @Id
    private String id;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "total_piece")
    private BigDecimal totalPiece;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_id")
    private Integer unitId;

    @Column(name = "unit_name")
    private String unitName;

    @Column
    private Integer count;
}
