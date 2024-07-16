package com.emrekirman.glaceon.inventory.product.service.impl;

import com.emrekirman.glaceon.inventory.common.entity.BaseDefinitionEntity;
import com.emrekirman.glaceon.inventory.common.entity.BaseEntity;
import com.emrekirman.glaceon.inventory.common.exception.CustomNotFoundException;
import com.emrekirman.glaceon.inventory.product.entity.Product;
import com.emrekirman.glaceon.inventory.product.mapper.ProductMapper;
import com.emrekirman.glaceon.inventory.product.model.ProductRequest;
import com.emrekirman.glaceon.inventory.product.model.ProductResponse;
import com.emrekirman.glaceon.inventory.product.model.ProductUpdateRequest;
import com.emrekirman.glaceon.inventory.product.repository.ProductRepository;
import com.emrekirman.glaceon.inventory.product.service.IProductApi;
import com.emrekirman.glaceon.inventory.product.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService, IProductApi {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductCheckMandaService productCheckMandaService;

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        Product product = productMapper.mapRequestToEntity(productRequest);

        BaseEntity.setCreateAudit(product);
        BaseDefinitionEntity.prepareCode(product);

        productCheckMandaService.createCheckManda(product);

        Product saved = productRepository.save(product);

        return productMapper.mapEntityToResponse(saved);
    }


    @Override
    public ProductResponse update(ProductUpdateRequest productUpdateRequest) {
        Product oldProduct = productRepository.findById(productUpdateRequest.getId())
                .orElseThrow(() -> new CustomNotFoundException("product.not.found"));

        Product product = productMapper.mapUpdateToEntity(productUpdateRequest, oldProduct);

        BaseEntity.setUpdateAudit(product);
        BaseDefinitionEntity.prepareCode(product);

        productCheckMandaService.updateCheckManda(product, oldProduct);

        Product saved = productRepository.save(product);

        return productMapper.mapEntityToResponse(saved);
    }

    @Override
    public void deleteById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("product.not.found"));

        BaseEntity.setDeleteAudit(product);

        productRepository.save(product);
    }

    @Override
    public List<ProductResponse> findAll() {
        List<Product> all = productRepository.findAll();

        return productMapper.mapEntityToResponseList(all);
    }

    @Override
    public ProductResponse findById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("product.not.found"));

        return productMapper.mapEntityToResponse(product);
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("product.not.found"));
    }
}
