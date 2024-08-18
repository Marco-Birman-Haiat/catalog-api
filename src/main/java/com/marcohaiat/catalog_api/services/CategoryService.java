package com.marcohaiat.catalog_api.services;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.domain.category.CategoryDTO;
import com.marcohaiat.catalog_api.reporitory.CategoryReporitory;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryReporitory categoryReporitory;

    public CategoryService(CategoryReporitory categoryReporitory) {
        this.categoryReporitory = categoryReporitory;
    }

    public Category insert(CategoryDTO categoryData) {
        Category newCategory = Category.toEntity(categoryData);
        this.categoryReporitory.save(newCategory);
        return newCategory;
    }
}
