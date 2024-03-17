package com.example.SpringJWT.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtService {

    private static final String SECRETE_KEY = "38E7F356DE5EBD112343C881D6A5C";
    public String extractUsername(String token){
        return null;
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getPublicSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getPublicSigningKey() {
        byte[] keyByte = Decoders.BASE64.decode(SECRETE_KEY);
        return Keys.hmacShaKeyFor(keyByte);
    }
}
