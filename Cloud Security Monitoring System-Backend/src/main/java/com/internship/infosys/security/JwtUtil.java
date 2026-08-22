package com.internship.infosys.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    // ===============================
    // Generate JWT Token
    // ===============================

    public String generateToken(String username) {

        Date now = new Date();

        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSigningKey())
                .compact();
    }

    // ===============================
    // Extract Username
    // ===============================

    public String extractUsername(String token) {

        return getClaims(token).getSubject();
    }

    // ===============================
    // Extract Expiration
    // ===============================

    public Date extractExpiration(String token) {

        return getClaims(token).getExpiration();
    }

    // ===============================
    // Validate Token
    // ===============================

    public boolean validateToken(String token, String username) {

        return extractUsername(token).equals(username)
                && !isTokenExpired(token);
    }

    // ===============================
    // Check Expiration
    // ===============================

    private boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
    }

    // ===============================
    // Parse Claims
    // ===============================

    private Claims getClaims(String token) {

        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}