package com.marcohaiat.catalog_api.reporitory.product.implementations;

import com.marcohaiat.catalog_api.domain.product.Product;
import com.marcohaiat.catalog_api.reporitory.category.implementations.InMemoryCategoryRepository;
import com.marcohaiat.catalog_api.reporitory.product.ProductRepository;
import com.marcohaiat.catalog_api.utils.idGenerator.CounterIdGenerator;
import com.marcohaiat.catalog_api.utils.idGenerator.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {
    private static final List<Product> memory = new ArrayList<>();
    private static final IdGenerator idGenerator = new CounterIdGenerator();

    @Override
    public Product save(Product prodyctData) {
        if (prodyctData.getId() == null) {
            prodyctData.setId(idGenerator.getNewId());
            memory.add(prodyctData);
        } else {
            update(prodyctData);
        }
        return prodyctData;
    }

    @Override
    public Optional<Product> findById(String productId) {
        return memory.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return InMemoryProductRepository.memory;
    }

    private void update(Product productData) {
        Product foundProduct = findById(productData.getId()).get();
        foundProduct = productData;
    }
}
