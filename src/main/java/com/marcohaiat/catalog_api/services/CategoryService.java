package com.marcohaiat.catalog_api.services;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.domain.category.CategoryDTO;
import com.marcohaiat.catalog_api.domain.category.CategoryNotFound;
import com.marcohaiat.catalog_api.reporitory.CategoryRepository;
import com.marcohaiat.catalog_api.reporitory.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final OwnerService ownerService;
    private final SNSService snsService;

    public CategoryService(CategoryRepository categoryRepository, SNSService snsService, OwnerService ownerService) {
        this.categoryRepository = categoryRepository;
        this.snsService = snsService;
        this.ownerService = ownerService;
    }

    public Category insert(CategoryDTO categoryData) {
        this.ownerService.checkIfOwnerExists(categoryData.ownerId());

        Category newCategory = Category.toEntity(categoryData);
        this.categoryRepository.save(newCategory);
        snsService.publish(newCategory.getId());
        return newCategory;
    }

    public void checkIfCategoryExists(String categoryId) {
        this.categoryRepository.findById(categoryId).orElseThrow(CategoryNotFound::new);
    }
}
