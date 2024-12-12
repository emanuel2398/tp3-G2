package edu.spring.istfi.controller;

import edu.spring.istfi.config.TokenBlacklist;
import edu.spring.istfi.entity.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    private final TokenBlacklist tokenBlacklist;

    public LoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,TokenBlacklist tokenBlacklist) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.tokenBlacklist=tokenBlacklist;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        try {
            String username = credentials.get("username");
            String password = credentials.get("password");

            if (username == null || password == null) {
                return ResponseEntity.badRequest().body("Faltan campos en la solicitud");
            }
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            String token = jwtUtil.generarToken(username);

            return ResponseEntity.ok(Map.of("token", "Bearer " + token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody Map<String, String> credentials) {
        String token = credentials.get("token");
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Token no proporcionado");
        }

        tokenBlacklist.blacklistToken(token.substring(7)); // Eliminar "Bearer "

        return ResponseEntity.ok("Logout exitoso");
    }

}
