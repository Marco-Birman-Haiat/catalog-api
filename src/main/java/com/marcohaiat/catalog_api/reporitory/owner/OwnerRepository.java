package com.marcohaiat.catalog_api.reporitory.owner;

import com.marcohaiat.catalog_api.domain.owner.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {
    Owner save(Owner ownerData);
    Optional<Owner> findById(String ownerId);
    List<Owner> findAll();
}
