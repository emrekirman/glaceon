package com.emrekirman.glaceon.inventory.transaction.controller;

import com.emrekirman.glaceon.inventory.transaction.model.TotalStockResponse;
import com.emrekirman.glaceon.inventory.transaction.model.TransactionRequest;
import com.emrekirman.glaceon.inventory.transaction.service.IStockService;
import com.emrekirman.glaceon.inventory.transaction.service.ITransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    private final ITransactionService transactionService;
    private final IStockService stockService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody TransactionRequest transactionRequest) {
        transactionService.create(transactionRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/stocks/by-product/{productId}")
    public ResponseEntity<TotalStockResponse> getTotalStock(@PathVariable Integer productId) {
        return ResponseEntity.ok(stockService.getTotalStockByProductId(productId));
    }
}
