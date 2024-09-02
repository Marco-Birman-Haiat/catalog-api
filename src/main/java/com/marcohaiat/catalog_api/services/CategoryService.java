package com.marcohaiat.catalog_api.services;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.domain.category.CategoryDTO;
import com.marcohaiat.catalog_api.exceptions.ExceptionMessages;
import com.marcohaiat.catalog_api.exceptions.notFoundExceptions.CategoryNotFoundException;
import com.marcohaiat.catalog_api.reporitory.category.CategoryRespository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
    private final CategoryRespository categoryRespository;
    private final OwnerService ownerService;
    private final SNSService snsService;
    private final MongoTemplate mongoTemplate;

    public CategoryService(CategoryRespository categoryRespository, SNSService snsService, OwnerService ownerService, MongoTemplate mongoTemplate) {
        this.categoryRespository = categoryRespository;
        this.snsService = snsService;
        this.ownerService = ownerService;
        this.mongoTemplate = mongoTemplate;
    }

    public Category insert(CategoryDTO categoryData) {
        this.ownerService.checkIfOwnerExists(categoryData.ownerId());

        Category newCategory = Category.toEntity(categoryData);
        this.categoryRespository.save(newCategory);
        snsService.publish(newCategory.getOwnerId());
        return newCategory;
    }

    public void checkIfCategoryExists(String categoryId) {
        this.categoryRespository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException(ExceptionMessages.CATEGORY_NOT_FOUND.getMessage()));
    }

    public List<Category> getAllCategoriesByOwnerId(String ownerId) {
        return categoryRespository.getAllByOwnerId(ownerId);
    }

    public List<Category> getAllCategoriesByOwnerId4(String ownerId) {
        Query query = new Query().addCriteria(Criteria.where("ownerId").is(ownerId));
        return mongoTemplate.find(query, Category.class);
    }

    public List<Category> findAll() {
        return this.categoryRespository.findAll();
    }
}
