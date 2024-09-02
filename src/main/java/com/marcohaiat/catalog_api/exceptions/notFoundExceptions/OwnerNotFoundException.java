package com.marcohaiat.catalog_api.exceptions.notFoundExceptions;

public class OwnerNotFoundException extends RuntimeException {
    public OwnerNotFoundException(String message) {
        super(message);
    }
}
