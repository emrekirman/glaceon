package com.emrekirman.glaceon.inventory.transaction.repository;

import com.emrekirman.glaceon.inventory.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("from Transaction t where t.unit.id=:unitId")
    List<Transaction> findAllByUnitId(@Param("unitId")Integer unitId);

    @Query("from Transaction t where t.product.id=:productId")
    List<Transaction> findAllByProductId(@Param("productId")Integer productId);

    @Query("from Transaction t where t.product.id=:productId and t.unit.id=:unitId")
    List<Transaction> findAllByProductIdAndUnitId(@Param("productId")Integer productId,@Param("unitId")Integer unitId);
}
