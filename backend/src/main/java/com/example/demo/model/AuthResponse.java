package com.example.demo.model;

public class AuthResponse {
    private String token;
    private String status;
    public AuthResponse(String token) {
        this.token = token;
        this.status = "ok";
    }

    public String getToken() {
        return token;
    }
    public String getStatus() {
        return status; // 有 getter 方法，所以可以返回给前端
    }

    public void setToken(String token) {
        this.token = token;
    }
}