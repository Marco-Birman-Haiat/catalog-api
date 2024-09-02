package com.marcohaiat.catalog_api.reporitory.category;

import com.marcohaiat.catalog_api.domain.category.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRespository {
    Category save(Category category);
    Optional<Category> findById(String id);
    List<Category> getAllByOwnerId(String ownerId);
}
