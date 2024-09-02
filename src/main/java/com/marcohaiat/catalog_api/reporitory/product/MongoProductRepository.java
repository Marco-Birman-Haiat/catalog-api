package com.marcohaiat.catalog_api.reporitory.product;

import com.marcohaiat.catalog_api.domain.product.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "repository.type", havingValue = "mongo")
public interface MongoProductRepository extends MongoRepository<Product, String>, ProductRepository {
}
