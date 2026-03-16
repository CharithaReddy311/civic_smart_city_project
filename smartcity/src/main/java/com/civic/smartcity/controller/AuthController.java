package com.civic.smartcity.controller;

import com.civic.smartcity.dto.AuthResponse;
import com.civic.smartcity.dto.LoginRequest;
import com.civic.smartcity.dto.RegisterRequest;
import com.civic.smartcity.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    // ✅ REGISTER
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        AuthResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    // ✅ LOGIN (JWT GENERATED HERE VIA SERVICE)
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}