package com.marcohaiat.catalog_api.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
