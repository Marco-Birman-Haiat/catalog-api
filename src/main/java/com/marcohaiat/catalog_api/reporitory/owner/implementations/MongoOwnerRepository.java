package com.marcohaiat.catalog_api.reporitory.owner.implementations;

import com.marcohaiat.catalog_api.domain.owner.Owner;
import com.marcohaiat.catalog_api.reporitory.owner.OwnerRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "repository.type", havingValue = "mongo")
public interface MongoOwnerRepository extends MongoRepository<Owner, String>, OwnerRepository {
}
