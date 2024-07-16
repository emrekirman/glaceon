package com.emrekirman.glaceon.inventory.product.service;

import com.emrekirman.glaceon.inventory.product.model.ProductRequest;
import com.emrekirman.glaceon.inventory.product.model.ProductResponse;
import com.emrekirman.glaceon.inventory.product.model.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    ProductResponse create(ProductRequest productRequest);

    ProductResponse update(ProductUpdateRequest productUpdateRequest);

    void deleteById(Integer id);

    List<ProductResponse> findAll();

    ProductResponse findById(Integer id);
}
