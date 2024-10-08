package com.marcohaiat.catalog_api.controllers;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.domain.category.CategoryDTO;
import com.marcohaiat.catalog_api.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData) {
        Category newCategory = this.categoryService.insert(categoryData);
        return ResponseEntity.ok(newCategory);
    }

    @GetMapping("/by-owner/{id}")
    public ResponseEntity<List<Category>> getCategoriesByOwner(@PathVariable("id") String ownerId) {
        List<Category> allOwnerCategories = this.categoryService.getAllCategoriesByOwnerId(ownerId);
        return ResponseEntity.ok(allOwnerCategories);
    }

    @GetMapping()
    public ResponseEntity<List<Category>> findAll() {
        return new ResponseEntity<List<Category>>(categoryService.findAll(), HttpStatus.OK);
    }
}
