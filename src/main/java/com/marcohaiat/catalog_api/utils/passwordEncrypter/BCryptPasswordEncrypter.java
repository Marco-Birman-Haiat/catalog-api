package com.marcohaiat.catalog_api.utils.passwordEncrypter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncrypter implements PasswordEncrypter {
    @Override
    public String encode(String decodedPassword) {
        return new BCryptPasswordEncoder().encode(decodedPassword);
    }
}
