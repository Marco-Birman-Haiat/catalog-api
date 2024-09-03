package com.marcohaiat.catalog_api.reporitory.user;

import com.marcohaiat.catalog_api.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<User, String> {
    UserDetails findByLogin(String login);
}
