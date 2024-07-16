package com.emrekirman.glaceon.inventory.transaction.mapper;

import com.emrekirman.glaceon.inventory.transaction.entity.Stock;
import com.emrekirman.glaceon.inventory.transaction.model.StockResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockMapper {

    StockResponse mapEntityToResponse(Stock stock);

    List<StockResponse> mapEntityToResponseList(List<Stock> stockList);
}
