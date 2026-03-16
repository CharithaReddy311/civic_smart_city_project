package com.civic.smartcity.dto;

public class AuthResponse {
    private String token;
    private String role;
    private String username;
    private String message;

    public AuthResponse(String token, String role, String username) {
        this.token = token;
        this.role = role;
        this.username = username;
        this.message = "Success";
    }

    public AuthResponse(String message) {
        this.message = message;
    }

    public String getToken() { return token; }
    public String getRole() { return role; }
    public String getUsername() { return username; }
    public String getMessage() { return message; }
}