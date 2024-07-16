package com.emrekirman.glaceon.inventory.product.controller;

import com.emrekirman.glaceon.inventory.product.model.ProductRequest;
import com.emrekirman.glaceon.inventory.product.model.ProductResponse;
import com.emrekirman.glaceon.inventory.product.model.ProductUpdateRequest;
import com.emrekirman.glaceon.inventory.product.service.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.create(productRequest);

        return ResponseEntity.ok(productResponse);
    }

    @PutMapping
    public ResponseEntity<ProductResponse> update(@Valid @RequestBody ProductUpdateRequest productUpdateRequest) {
        ProductResponse update = productService.update(productUpdateRequest);

        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }
}
