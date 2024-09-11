package com.marcohaiat.catalog_api.controllers;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.domain.category.CategoryDTO;
import com.marcohaiat.catalog_api.domain.product.Product;
import com.marcohaiat.catalog_api.domain.product.ProductDTO;
import com.marcohaiat.catalog_api.services.CategoryService;
import com.marcohaiat.catalog_api.services.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<List<Product>>(this.productService.findAll(), HttpStatus.OK);
    }
}
