package com.marcohaiat.catalog_api.services;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.domain.category.CategoryDTO;
import com.marcohaiat.catalog_api.domain.product.Product;
import com.marcohaiat.catalog_api.domain.product.ProductDTO;
import com.marcohaiat.catalog_api.reporitory.CategoryRepository;
import com.marcohaiat.catalog_api.reporitory.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final SNSService snsService;

    public ProductService(ProductRepository productRepository, SNSService snsService) {
        this.productRepository = productRepository;
        this.snsService = snsService;
    }

    public Product insert(ProductDTO productData) {
        Product newProduct = Product.toEntity(productData);
        this.productRepository.save(newProduct);
        snsService.publish(newProduct.getOwnerId());
        return newProduct;
    }
}
