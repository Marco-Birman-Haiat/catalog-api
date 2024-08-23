package com.marcohaiat.catalog_api.controllers;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.domain.category.CategoryDTO;
import com.marcohaiat.catalog_api.domain.product.Product;
import com.marcohaiat.catalog_api.domain.product.ProductDTO;
import com.marcohaiat.catalog_api.services.CategoryService;
import com.marcohaiat.catalog_api.services.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productData) {
        Product newProduct = this.productService.insert(productData);
        return ResponseEntity.ok(newProduct);
    }
}
