package com.civic.smartcity.service;

import com.civic.smartcity.dto.*;
import com.civic.smartcity.model.User;
import com.civic.smartcity.repository.UserRepository;
import com.civic.smartcity.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ REGISTER
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setEmail(request.getEmail());       // ✅ ADDED
        user.setPhone(request.getPhone());       // ✅ ADDED

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());

        return new AuthResponse(token, user.getRole(), user.getUsername());  // ✅ FIXED
    }

    // ✅ LOGIN
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());

        return new AuthResponse(token, user.getRole(), user.getUsername());  // ✅ FIXED
    }
}