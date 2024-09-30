package com.example.demo.controller;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/auth") //之后的所有请求都以/auth开头
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    @GetMapping("/currentUser")
    public ResponseEntity<?> getUser(@RequestParam String token) {
        //从JWT中解析出用户名
        String username = jwtUtil.extractUsername(token);
        System.out.println(username);
        User user = userService.findByUsername(username);

        if (user != null) {
            UserDTO userDTO = new UserDTO(user.isAdmin(), user.getUsername());
//            System.out.println("是管理员吗？"+user.isAdmin());
            return ResponseEntity.ok(Collections.singletonMap("data", userDTO));
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
    // 登录方法
    @PostMapping("/account")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
//随便输出点中文
            System.out.println("中文");

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            //输出认证信息

            String token = jwtUtil.generateToken(authRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    // 注册方法
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest authRequest) {
        User user = userService.registerUser(authRequest.getUsername(), authRequest.getPassword());
        return ResponseEntity.ok("User registered: " + user.getUsername());
    }
}
