package com.marcohaiat.catalog_api.controllers;

import com.marcohaiat.catalog_api.domain.user.AuthenticationDTO;
import com.marcohaiat.catalog_api.domain.user.LoginResponseDTO;
import com.marcohaiat.catalog_api.domain.user.RegisterDTO;
import com.marcohaiat.catalog_api.reporitory.user.UserRepository;
import com.marcohaiat.catalog_api.services.security.AuthService;
import com.marcohaiat.catalog_api.services.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthService authService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO authData) {
        String token = this.authService.authenticateUser(authData);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO registerData) {
        this.authService.register(registerData);
        return ResponseEntity.ok("user created");
    }
}
