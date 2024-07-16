package com.emrekirman.glaceon.inventory.transaction.service.impl;

import com.emrekirman.glaceon.inventory.common.exception.CustomRuntimeException;
import com.emrekirman.glaceon.inventory.transaction.entity.Stock;
import com.emrekirman.glaceon.inventory.transaction.model.TransactionMovement;
import com.emrekirman.glaceon.inventory.transaction.model.TransactionRequest;
import com.emrekirman.glaceon.inventory.transaction.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCheckMandaService {
    private final StockRepository stockRepository;

    public void createCheckManda(TransactionRequest transactionRequest) {
        if (transactionRequest.getMovement().equals(TransactionMovement.OUT)) {
            Stock stock = stockRepository.findByUnitIdAndProductId(transactionRequest.getUnitId(), transactionRequest.getProductId());

            if (transactionRequest.getPiece().compareTo(stock.getTotalPiece()) > 0) {
                throw new CustomRuntimeException("not.enough.stock");
            }
        }
    }
}
