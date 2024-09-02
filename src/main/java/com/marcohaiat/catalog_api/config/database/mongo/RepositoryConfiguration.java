package com.marcohaiat.catalog_api.config.database.mongo;

import com.marcohaiat.catalog_api.reporitory.category.CategoryRespository;
import com.marcohaiat.catalog_api.reporitory.category.implementations.InMemoryCategoryRepository;
import com.marcohaiat.catalog_api.reporitory.owner.OwnerRepository;
import com.marcohaiat.catalog_api.reporitory.owner.implementations.InMemoryOwnerRepository;
import com.marcohaiat.catalog_api.reporitory.product.InMemoryProductRepository;
import com.marcohaiat.catalog_api.reporitory.product.ProductRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    @ConditionalOnProperty(name = "repository.type", havingValue = "in-memory")
    public CategoryRespository inMemoryCategoryRepository() {
        return new InMemoryCategoryRepository();
    }

    @Bean
    @ConditionalOnProperty(name = "repository.type", havingValue = "in-memory")
    public OwnerRepository inMemoryOwnerRepository() {
        return new InMemoryOwnerRepository();
    }

    @Bean
    @ConditionalOnProperty(name = "repository.type", havingValue = "in-memory")
    public ProductRepository inMemoryProductRepository() {
        return new InMemoryProductRepository();
    }
}
