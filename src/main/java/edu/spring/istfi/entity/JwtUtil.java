package edu.spring.istfi.entity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("claveSecretaParaJWTDe256bitsPorFavorCambiar".getBytes(StandardCharsets.UTF_8));

    public String generarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token válido por 10 horas
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }


    public String extraerUsername(String token) {
        return obtenerClaims(token).getSubject();
    }

    public boolean validarToken(String token, String username) {
        return username.equals(extraerUsername(token)) && !tokenExpirado(token);
    }

    private Claims obtenerClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean tokenExpirado(String token) {
        return obtenerClaims(token).getExpiration().before(new Date());
    }
}