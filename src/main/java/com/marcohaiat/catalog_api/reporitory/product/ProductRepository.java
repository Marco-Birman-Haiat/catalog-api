package com.marcohaiat.catalog_api.reporitory.product;

import com.marcohaiat.catalog_api.domain.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product productData);
    Optional<Product> findById(String productId);
    List<Product> findAll();
}
