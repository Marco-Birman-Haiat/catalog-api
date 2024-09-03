package com.marcohaiat.catalog_api.utils.passwordEncrypter;

public interface PasswordEncrypter {
    String encode(String decodedPassword);
}
