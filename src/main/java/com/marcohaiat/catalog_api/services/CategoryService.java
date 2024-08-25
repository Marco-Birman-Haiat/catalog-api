package com.marcohaiat.catalog_api.services;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.domain.category.CategoryDTO;
import com.marcohaiat.catalog_api.domain.category.CategoryNotFound;
import com.marcohaiat.catalog_api.reporitory.CategoryRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final OwnerService ownerService;
    private final SNSService snsService;
    private final MongoTemplate mongoTemplate;

    public CategoryService(CategoryRepository categoryRepository, SNSService snsService, OwnerService ownerService, MongoTemplate mongoTemplate) {
        this.categoryRepository = categoryRepository;
        this.snsService = snsService;
        this.ownerService = ownerService;
        this.mongoTemplate = mongoTemplate;
    }

    public Category insert(CategoryDTO categoryData) {
        this.ownerService.checkIfOwnerExists(categoryData.ownerId());

        Category newCategory = Category.toEntity(categoryData);
        this.categoryRepository.save(newCategory);
        snsService.publish(newCategory.getOwnerId());
        return newCategory;
    }

    public void checkIfCategoryExists(String categoryId) {
        this.categoryRepository.findById(categoryId).orElseThrow(CategoryNotFound::new);
    }

    public List<Category> getAllCategoriesByOwnerId(String ownerId) {
        return mongoTemplate.query(Category.class)
                .matching(Query.query(where("ownerId").is(ownerId)))
                .all();
    }

    public List<Category> getAllCategoriesByOwnerId2(String ownerId) {
        return this.categoryRepository.getAllCategoriesByOwnerId2(ownerId);
    }

    public List<Category> getAllCategoriesByOwnerId4(String ownerId) {
        Query query = new Query().addCriteria(Criteria.where("ownerId").is(ownerId));
        return mongoTemplate.find(query, Category.class);
    }
}
