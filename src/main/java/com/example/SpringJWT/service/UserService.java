package com.example.SpringJWT.service;

import com.example.SpringJWT.config.JwtService;
import com.example.SpringJWT.dto.AuthenticationResponse;
import com.example.SpringJWT.dto.UserLogIn;
import com.example.SpringJWT.dto.UserSignIn;
import com.example.SpringJWT.model.Role;
import com.example.SpringJWT.model.Users;
import com.example.SpringJWT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private  final JwtService jwtService;
    private  final AuthenticationManager authManager;


    public AuthenticationResponse registerUser(UserSignIn userSignIn){
        var user = Users.builder()
                .username(userSignIn.getUsername())
                .email(userSignIn.getEmail())
                .Password(passwordEncoder.encode(userSignIn.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public  AuthenticationResponse loginInuser(UserLogIn userLogIn){
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLogIn.getUsername(),
                        userLogIn.getPassword()

                )
        );
        var user = userRepository.findByUsername(userLogIn.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
