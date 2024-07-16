package com.emrekirman.glaceon.inventory.transaction.service.impl;

import com.emrekirman.glaceon.inventory.common.entity.BaseEntity;
import com.emrekirman.glaceon.inventory.product.entity.Product;
import com.emrekirman.glaceon.inventory.product.service.IProductApi;
import com.emrekirman.glaceon.inventory.transaction.entity.Transaction;
import com.emrekirman.glaceon.inventory.transaction.mapper.TransactionMapper;
import com.emrekirman.glaceon.inventory.transaction.model.TransactionMovement;
import com.emrekirman.glaceon.inventory.transaction.model.TransactionRequest;
import com.emrekirman.glaceon.inventory.transaction.repository.TransactionRepository;
import com.emrekirman.glaceon.inventory.transaction.service.ITransactionService;
import com.emrekirman.glaceon.inventory.unit.entity.Unit;
import com.emrekirman.glaceon.inventory.unit.service.IUnitApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final TransactionCheckMandaService transactionCheckMandaService;
    private final IUnitApi unitApi;
    private final IProductApi productApi;


    @Override
    public void create(TransactionRequest transactionRequest) {

        Transaction transaction = transactionMapper.mapRequestToEntity(transactionRequest);

        Unit byIdUnit = unitApi.getById(transactionRequest.getUnitId());
        transaction.setUnit(byIdUnit);

        Product byIdProduct = productApi.getById(transactionRequest.getProductId());
        transaction.setProduct(byIdProduct);

        calculateTotalAmount(transaction);

        BaseEntity.setCreateAudit(transaction);

        if (TransactionMovement.OUT.equals(transaction.getMovement())) {
            transactionCheckMandaService.createCheckManda(transactionRequest);

            transaction.setTotalAmount(this.reversePen(transaction.getTotalAmount()));
            transaction.setPiece(this.reversePen(transaction.getPiece()));
        }

        transactionRepository.save(transaction);
    }

    private BigDecimal reversePen(BigDecimal value) {
        return value.multiply(new BigDecimal("-1"));
    }

    private void calculateTotalAmount(Transaction transaction) {
        BigDecimal piece = transaction.getPiece();
        BigDecimal unitPrice = transaction.getUnitPrice();
        BigDecimal discountRate = transaction.getDiscountRate();

        BigDecimal totalAmount = BigDecimal.ZERO;

        totalAmount = totalAmount.add(unitPrice.multiply(piece));

        if (discountRate != null && discountRate.compareTo(new BigDecimal("0")) > 0) {
            totalAmount = totalAmount.subtract(totalAmount.multiply(discountRate).divide(new BigDecimal("100")));
        }

        transaction.setTotalAmount(totalAmount);
    }
}
