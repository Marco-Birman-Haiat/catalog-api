package com.marcohaiat.catalog_api.reporitory;

import com.marcohaiat.catalog_api.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReporitory extends MongoRepository<Category, String> {
}
