package com.emrekirman.glaceon.gateway.external.inventory.service.transaction;

import com.emrekirman.glaceon.gateway.external.inventory.model.transaction.TotalStockResponse;
import com.emrekirman.glaceon.gateway.external.inventory.model.transaction.TransactionRequest;
import com.emrekirman.glaceon.gateway.external.inventory.model.transaction.TransactionResponse;

public interface ITransactionService {
    TransactionResponse create(TransactionRequest transactionRequest);

    TotalStockResponse getStockByProductId(Integer productId);
}
