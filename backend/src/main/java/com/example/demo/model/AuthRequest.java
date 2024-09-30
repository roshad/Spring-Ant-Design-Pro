package com.example.demo.model;

public class AuthRequest {
    private String username;
    private String password;
    private String userId;
    // Getters 和 Setters
    public String getUsername() {
        return username;
    }
    public String getUserId() {
        return userId;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
