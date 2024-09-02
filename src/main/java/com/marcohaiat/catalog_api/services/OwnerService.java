package com.marcohaiat.catalog_api.services;

import com.marcohaiat.catalog_api.domain.owner.Owner;
import com.marcohaiat.catalog_api.domain.owner.OwnerDTO;
import com.marcohaiat.catalog_api.domain.owner.OwnerNotFoundException;
import com.marcohaiat.catalog_api.reporitory.owner.OwnerRepository;
import com.marcohaiat.catalog_api.reporitory.owner.implementations.MongoOwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner insert(OwnerDTO ownerData) {
        Owner newOwner = Owner.toEntity(ownerData);
        ownerRepository.save(newOwner);
        return newOwner;
    }

    public void checkIfOwnerExists(String ownerId) throws OwnerNotFoundException {
        ownerRepository.findById(ownerId).orElseThrow(OwnerNotFoundException::new);
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }
}
