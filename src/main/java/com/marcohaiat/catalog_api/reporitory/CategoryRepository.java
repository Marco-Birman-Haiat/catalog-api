package com.marcohaiat.catalog_api.reporitory;

import com.marcohaiat.catalog_api.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    @Query("{'ownerId': ?0}")
    List<Category> getAllCategoriesByOwnerId2(String id);
}
