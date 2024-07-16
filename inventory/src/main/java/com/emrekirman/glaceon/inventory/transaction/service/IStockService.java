package com.emrekirman.glaceon.inventory.transaction.service;

import com.emrekirman.glaceon.inventory.transaction.model.TotalStockResponse;

public interface IStockService {
    TotalStockResponse getTotalStockByProductId(Integer productId);
}
