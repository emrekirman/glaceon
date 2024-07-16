package com.emrekirman.glaceon.inventory.transaction.service;

import com.emrekirman.glaceon.inventory.transaction.model.TransactionRequest;

public interface ITransactionService {
    void create(TransactionRequest transactionRequest);
}
