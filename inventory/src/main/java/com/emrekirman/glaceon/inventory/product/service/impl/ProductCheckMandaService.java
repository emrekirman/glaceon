package com.emrekirman.glaceon.inventory.product.service.impl;

import com.emrekirman.glaceon.inventory.common.exception.CustomRuntimeException;
import com.emrekirman.glaceon.inventory.product.entity.Product;
import com.emrekirman.glaceon.inventory.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCheckMandaService {
    private final ProductRepository productRepository;

    public void createCheckManda(Product product) {
        if (productRepository.existsByCode(product.getCode())) {
            throw new CustomRuntimeException("product.already.added");
        }
    }

    public void updateCheckManda(Product product, Product oldProduct) {
        if (!oldProduct.getCode().equals(product.getCode())) {
            if (productRepository.existsByCodeAndIdNot(product.getCode(), product.getId())) {
                throw new CustomRuntimeException("product.already.added");
            }
        }
    }
}
