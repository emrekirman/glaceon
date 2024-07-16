package com.emrekirman.glaceon.gateway.external.inventory.controller.transaction;

import com.emrekirman.glaceon.gateway.external.inventory.model.transaction.TotalStockResponse;
import com.emrekirman.glaceon.gateway.external.inventory.model.transaction.TransactionRequest;
import com.emrekirman.glaceon.gateway.external.inventory.model.transaction.TransactionResponse;
import com.emrekirman.glaceon.gateway.external.inventory.service.transaction.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponse> create(@RequestBody TransactionRequest transactionRequest) {
        return ResponseEntity.ok(transactionService.create(transactionRequest));
    }

    @GetMapping("/stocks/by-product/{productId}")
    public ResponseEntity<TotalStockResponse> getTotalStocks(@PathVariable Integer productId) {
        return ResponseEntity.ok(transactionService.getStockByProductId(productId));
    }
}
