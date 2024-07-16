package com.emrekirman.glaceon.inventory.transaction.repository;

import com.emrekirman.glaceon.inventory.transaction.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

    Stock findByUnitIdAndProductId(Integer unitId, Integer productId);

    List<Stock> findAllByProductId(Integer productId);
}
