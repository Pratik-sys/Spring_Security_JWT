package com.example.SpringJWT.service;

import com.example.SpringJWT.config.JwtService;
import com.example.SpringJWT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private  final JwtService jwtService;
    private  final AuthenticationManager authManager;



}
