package com.emrekirman.glaceon.inventory.product.mapper;

import com.emrekirman.glaceon.inventory.common.mapper.IBaseMapper;
import com.emrekirman.glaceon.inventory.product.entity.Product;
import com.emrekirman.glaceon.inventory.product.model.ProductRequest;
import com.emrekirman.glaceon.inventory.product.model.ProductResponse;
import com.emrekirman.glaceon.inventory.product.model.ProductUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper extends IBaseMapper<ProductRequest, ProductResponse, Product> {

    @Mapping(target = "id", source = "updateModel.id")
    @Mapping(target = "createdDate", source = "product.createdDate")
    @Mapping(target = "createdUser", source = "product.createdUser")
    @Mapping(target = "name", source = "updateModel.name")
    @Mapping(target = "code", source = "updateModel.code")
    Product mapUpdateToEntity(ProductUpdateRequest updateModel, Product product);
}
