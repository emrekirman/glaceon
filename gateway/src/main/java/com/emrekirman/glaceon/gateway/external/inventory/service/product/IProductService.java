package com.emrekirman.glaceon.gateway.external.inventory.service.product;

import com.emrekirman.glaceon.gateway.external.inventory.model.product.ProductRequest;
import com.emrekirman.glaceon.gateway.external.inventory.model.product.ProductResponse;
import com.emrekirman.glaceon.gateway.external.inventory.model.product.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    ProductResponse create(ProductRequest productRequest);

    ProductResponse update(ProductUpdateRequest productUpdateRequest);

    void deleteById(Integer id);

    List<ProductResponse> findAll();

    ProductResponse findById(Integer id);
}
