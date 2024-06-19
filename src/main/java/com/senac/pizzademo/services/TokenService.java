package com.senac.pizzademo.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.senac.pizzademo.model.User;

@Service
public class TokenService {

    private static final String SECRET = "secreta";

    public String gerarToken(User usuario) {
        Instant expirationTime = LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.of("-03:00"));

        return JWT.create()
            .withIssuer("PizzaDemoApp")
            .withSubject(usuario.getUsername())
            .withClaim("isAdmin", usuario.getId())
            .withClaim("id", usuario.getId())
            .withExpiresAt(Date.from(expirationTime))
            .sign(Algorithm.HMAC256(SECRET));
    }
}
