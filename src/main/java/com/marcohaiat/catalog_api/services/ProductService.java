package com.marcohaiat.catalog_api.services;

import com.marcohaiat.catalog_api.domain.product.Product;
import com.marcohaiat.catalog_api.domain.product.ProductDTO;
import com.marcohaiat.catalog_api.reporitory.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final OwnerService ownerService;
    private final CategoryService categoryService;
    private final SNSService snsService;

    public ProductService(ProductRepository productRepository, SNSService snsService, OwnerService ownerService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.snsService = snsService;
        this.ownerService = ownerService;
        this.categoryService = categoryService;
    }

    public Product insert(ProductDTO productData) {
        // validations before insertion
        this.ownerService.checkIfOwnerExists(productData.ownerId());
        if (!productData.categoryId().isEmpty()) {
            this.categoryService.checkIfCategoryExists(productData.categoryId());
        }

        Product newProduct = Product.toEntity(productData);
        this.productRepository.save(newProduct);
        snsService.publish(newProduct.getOwnerId());
        return newProduct;
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
}
