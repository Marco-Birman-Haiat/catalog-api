package com.marcohaiat.catalog_api.reporitory.category.implementations;

import com.marcohaiat.catalog_api.domain.category.Category;
import com.marcohaiat.catalog_api.reporitory.category.CategoryRespository;
import com.marcohaiat.catalog_api.utils.idGenerator.CounterIdGenerator;
import com.marcohaiat.catalog_api.utils.idGenerator.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryCategoryRepository implements CategoryRespository {
    private static final List<Category> memory = new ArrayList<>();
    private static final IdGenerator idGenerator = new CounterIdGenerator();

    @Override
    public Category save(Category category) {
        if (category.getId() == null) {
            category.setId(idGenerator.getNewId());
            memory.add(category);
        } else {
            update(category);
        }
        return category;
    }

    @Override
    public Optional<Category> findById(String categoryId) {
        return InMemoryCategoryRepository.memory.stream()
                .filter(category -> category.getId().equals(categoryId))
                .findFirst();
    }

    @Override
    public List<Category> getAllByOwnerId(String ownerId) {
        return InMemoryCategoryRepository.memory.stream()
                .filter(category -> category.getOwnerId().equals(ownerId))
                .toList();
    }

    @Override
    public List<Category> findAll() {
        return InMemoryCategoryRepository.memory;
    }

    private void update(Category category) {
        Category foundCategory = findById(category.getId()).get();
        foundCategory = category;
    }
}
