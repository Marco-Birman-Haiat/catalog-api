package com.marcohaiat.catalog_api.controllers;

import com.marcohaiat.catalog_api.domain.owner.Owner;
import com.marcohaiat.catalog_api.domain.owner.OwnerDTO;
import com.marcohaiat.catalog_api.services.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public ResponseEntity<Owner> insert(@RequestBody OwnerDTO ownerData) {
        Owner newOwner = this.ownerService.insert(ownerData);
        return new ResponseEntity<Owner>(newOwner, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Owner>> findAll() {
        return new ResponseEntity<List<Owner>>(this.ownerService.findAll(), HttpStatus.OK);
    }
}
