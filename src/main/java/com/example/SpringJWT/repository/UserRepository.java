package com.example.SpringJWT.repository;

import com.example.SpringJWT.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {


    Optional<Users> findByEmail(String email);
    Optional<Users> findByUsername(String username);
}
