package com.marcohaiat.catalog_api.controllers;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.domain.category.CategoryDTO;
import com.marcohaiat.catalog_api.services.CategoryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;
    // test
    @Value("${test}")
    private String test;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData) {
        Category newCategory = this.categoryService.insert(categoryData);
        System.out.println("LOGG DO TESTE --->  " + this.test);
        return ResponseEntity.ok(newCategory);
    }
}
