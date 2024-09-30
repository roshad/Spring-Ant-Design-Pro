package com.example.demo.util;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final String secretKey = "your_secret_key"; // 替换为您的密钥
    private final long expirationTime = 1000 * 60 * 60; // 1小时有效期

    // 生成 JWT
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    // 创建 JWT
    private String createToken(Map<String, Object> claims, String subject) {
        return JWT.create()

                .withSubject(subject)
                .withIssuer("auth0")
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC256(secretKey));
    }

    // 验证 JWT
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // 提取用户名
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // 检查 Token 是否过期
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiresAt().before(new Date());
    }

    // 提取所有声明
    private DecodedJWT extractAllClaims(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).withIssuer("auth0").build();
        return verifier.verify(token);
    }
}
