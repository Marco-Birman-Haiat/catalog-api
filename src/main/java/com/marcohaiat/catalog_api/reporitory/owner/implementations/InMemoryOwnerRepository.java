package com.marcohaiat.catalog_api.reporitory.owner.implementations;

import com.marcohaiat.catalog_api.domain.owner.Owner;
import com.marcohaiat.catalog_api.reporitory.owner.OwnerRepository;
import com.marcohaiat.catalog_api.utils.idGenerator.CounterIdGenerator;
import com.marcohaiat.catalog_api.utils.idGenerator.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryOwnerRepository implements OwnerRepository {
    private static final List<Owner> memory = new ArrayList<>();
    private static final IdGenerator idGenerator = new CounterIdGenerator();

    @Override
    public Owner save(Owner owner) {
        if (owner.getId() == null) {
            owner.setId(idGenerator.getNewId());
            memory.add(owner);
        } else {
            update(owner);
        }
        return owner;
    }

    @Override
    public Optional<Owner> findById(String ownerId) {
        return memory.stream()
                .filter(category -> category.getId().equals(ownerId))
                .findFirst();
    }

    @Override
    public List<Owner> findAll() {
        return InMemoryOwnerRepository.memory;
    }

    private void update(Owner ownerData) {
        Owner foundOwner = findById(ownerData.getId()).get();
        foundOwner = ownerData;
    }
}
