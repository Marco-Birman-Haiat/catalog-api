package com.marcohaiat.catalog_api.domain.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    private String id;
    private String name;
    private String description;


    private Category(CategoryDTO categoryDTO) {
        this.id = categoryDTO.id();
        this.name = categoryDTO.name();
        this.description = categoryDTO.description();
    }

    public static Category toEntity(CategoryDTO categoryDTO) {
        return new Category(categoryDTO);
    }
}
