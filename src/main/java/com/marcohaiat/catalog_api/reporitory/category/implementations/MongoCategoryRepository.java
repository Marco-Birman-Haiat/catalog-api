package com.marcohaiat.catalog_api.reporitory.category.implementations;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.reporitory.category.CategoryRespository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ConditionalOnProperty(name = "repository.type", havingValue = "mongo")
public interface MongoCategoryRepository extends MongoRepository<Category, String>, CategoryRespository {

    @Query("{'ownerId': ?0}")
    List<Category> getAllByOwnerId(String id);
}
