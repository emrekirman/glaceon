package com.emrekirman.glaceon.inventory.transaction.service.impl;

import com.emrekirman.glaceon.inventory.common.exception.CustomRuntimeException;
import com.emrekirman.glaceon.inventory.transaction.entity.Stock;
import com.emrekirman.glaceon.inventory.transaction.mapper.StockMapper;
import com.emrekirman.glaceon.inventory.transaction.model.TotalStockResponse;
import com.emrekirman.glaceon.inventory.transaction.repository.StockRepository;
import com.emrekirman.glaceon.inventory.transaction.service.IStockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockService implements IStockService {
    private final StockRepository stockRepository;
    private final StockMapper stockMapper;


    @Override
    public TotalStockResponse getTotalStockByProductId(Integer productId) {
        log.info("getTotalStockByProductId, total stocks fetched. productId : {}", productId);


        List<Stock> allByProductId = stockRepository.findAllByProductId(productId);

        BigDecimal totalAmount = allByProductId.stream()
                .map(Stock::getTotalAmount)
                .reduce(BigDecimal::add)
                .orElseThrow(() -> new CustomRuntimeException("stock.not.calculated"));

        return TotalStockResponse
                .builder()
                .stockList(stockMapper.mapEntityToResponseList(allByProductId))
                .totalAmount(totalAmount)
                .build();
    }
}
