package com.marcohaiat.catalog_api.exceptions.notFoundExceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
