package com.marcohaiat.catalog_api.exceptions;

public enum ExceptionMessages {
    CATEGORY_NOT_FOUND("categoria não encontrada"),
    OWNER_NOT_FOUND("owner não encontrado");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
