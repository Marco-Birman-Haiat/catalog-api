package com.marcohaiat.catalog_api.domain.user;

public enum UserRole {
    ADMIN("ADMIN"),
    ANALYST("ANALYST"),
    USER("USER");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
