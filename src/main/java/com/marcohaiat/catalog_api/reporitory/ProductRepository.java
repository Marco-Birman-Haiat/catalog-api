package com.marcohaiat.catalog_api.reporitory;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
