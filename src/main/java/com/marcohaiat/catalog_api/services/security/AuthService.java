package com.marcohaiat.catalog_api.services.security;

import com.marcohaiat.catalog_api.domain.user.AuthenticationDTO;
import com.marcohaiat.catalog_api.domain.user.RegisterDTO;
import com.marcohaiat.catalog_api.domain.user.User;
import com.marcohaiat.catalog_api.domain.user.UserAlreadyExists;
import com.marcohaiat.catalog_api.reporitory.user.UserRepository;
import com.marcohaiat.catalog_api.utils.passwordEncrypter.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PasswordEncrypter passwordEncrypter;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    public String authenticateUser(AuthenticationDTO authData) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(authData.login(), authData.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        return tokenService.generateToken((User) auth.getPrincipal());
    }

    public void register(RegisterDTO registerData) {
        if (this.userRepository.findByLogin(registerData.login()) != null) throw new UserAlreadyExists("user already exists");

        String encryptedPassword = passwordEncrypter.encode(registerData.password());
        User newUser = new User(registerData.login(), encryptedPassword, registerData.role());
        this.userRepository.save(newUser);
    }
}
