package com.marcohaiat.catalog_api.domain.product;

import java.math.BigDecimal;

public record ProductDTO(String id, String title, String ownerId, String categoryId, BigDecimal price, String description) {
}

