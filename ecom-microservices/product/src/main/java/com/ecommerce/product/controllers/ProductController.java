package com.ecommerce.product.controllers;


import com.ecommerce.product.dtos.ProductRequest;
import com.ecommerce.product.dtos.ProductResponse;
import com.ecommerce.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    private ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest ProductRequest) {
        return new ResponseEntity<ProductResponse>(productService.createProduct(ProductRequest), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping("{id}")
    private ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(id, productRequest).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    private ResponseEntity<List<ProductResponse>> searchProducts(@RequestParam String keyword) {
        return ResponseEntity.of(Optional.ofNullable(productService.searchProducts(keyword)));
    }

}
