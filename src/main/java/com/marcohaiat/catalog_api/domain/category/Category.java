package com.marcohaiat.catalog_api.domain.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;


    private Category(CategoryDTO categoryDTO) {
        this.id = categoryDTO.id();
        this.title = categoryDTO.title();
        this.description = categoryDTO.description();
        this.ownerId = categoryDTO.ownerId();
    }

    public static Category toEntity(CategoryDTO categoryDTO) {
        return new Category(categoryDTO);
    }
}
