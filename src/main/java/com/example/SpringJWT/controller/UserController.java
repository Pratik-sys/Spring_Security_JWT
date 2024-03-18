package com.example.SpringJWT.controller;

import com.example.SpringJWT.dto.AuthenticationResponse;
import com.example.SpringJWT.dto.UserLogIn;
import com.example.SpringJWT.dto.UserSignIn;
import com.example.SpringJWT.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody UserSignIn userSignIn){
        return  ResponseEntity.ok().body(userService.registerUser(userSignIn));
    }

    @PostMapping("/login")
    public  ResponseEntity<AuthenticationResponse> loginUser(@RequestBody UserLogIn userLogIn){
        return  ResponseEntity.ok().body(userService.loginInuser(userLogIn));
    }
    @DeleteMapping("/removeUser/{id}")
    public  String removeUser(@PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }

}
