package com.marcohaiat.catalog_api.domain.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collation = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String title;
    private String description;
    private BigDecimal price;
    private String ownerId;
    private String categoryId;


    private Product(ProductDTO productDTO) {
        this.id = productDTO.id();
        this.title = productDTO.title();
        this.description = productDTO.description();
        this.ownerId = productDTO.ownerId();
        this.price = productDTO.price();
        this.categoryId = productDTO.categoryId();
    }

    public static Product toEntity(ProductDTO productDTO) {
        return new Product(productDTO);
    }
}
