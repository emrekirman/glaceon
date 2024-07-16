package com.emrekirman.glaceon.gateway.external.inventory.controller.product;

import com.emrekirman.glaceon.gateway.external.inventory.model.product.ProductRequest;
import com.emrekirman.glaceon.gateway.external.inventory.model.product.ProductResponse;
import com.emrekirman.glaceon.gateway.external.inventory.model.product.ProductUpdateRequest;
import com.emrekirman.glaceon.gateway.external.inventory.service.product.IProductService;
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
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.create(productRequest));
    }

    @PutMapping
    public ResponseEntity<ProductResponse> update(@RequestBody ProductUpdateRequest updateRequest) {
        return ResponseEntity.ok(productService.update(updateRequest));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
