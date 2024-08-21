package com.marcohaiat.catalog_api.services;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.domain.category.CategoryDTO;
import com.marcohaiat.catalog_api.reporitory.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final SNSService snsService;

    public CategoryService(CategoryRepository categoryRepository, SNSService snsService) {
        this.categoryRepository = categoryRepository;
        this.snsService = snsService;
    }

    public Category insert(CategoryDTO categoryData) {
        Category newCategory = Category.toEntity(categoryData);
        this.categoryRepository.save(newCategory);
        snsService.publish(newCategory.getId());
        return newCategory;
    }
}
