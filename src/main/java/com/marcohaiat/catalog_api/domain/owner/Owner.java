package com.marcohaiat.catalog_api.domain.owner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "owners")
@Getter
@Setter
@NoArgsConstructor
public class Owner {
    @Id
    private String id;
    private String name;

    public Owner(OwnerDTO ownerData) {
        this.id = ownerData.id();
        this.name = ownerData.name();
    }

    public static Owner toEntity(OwnerDTO ownerData) {
        return new Owner(ownerData);
    }
}
