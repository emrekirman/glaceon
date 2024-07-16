package com.emrekirman.glaceon.inventory.transaction.mapper;

import com.emrekirman.glaceon.inventory.common.mapper.IBaseMapper;
import com.emrekirman.glaceon.inventory.product.mapper.ProductMapper;
import com.emrekirman.glaceon.inventory.transaction.entity.Transaction;
import com.emrekirman.glaceon.inventory.transaction.model.TransactionRequest;
import com.emrekirman.glaceon.inventory.transaction.model.TransactionResponse;
import com.emrekirman.glaceon.inventory.unit.mapper.UnitMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {UnitMapper.class, ProductMapper.class})
public interface TransactionMapper extends IBaseMapper<TransactionRequest, TransactionResponse, Transaction> {
}
