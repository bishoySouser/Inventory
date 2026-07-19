package org.example.ventory.controller.user;

import org.example.ventory.dto.LoginRequest;
import org.example.ventory.security.JwtUtils;
import org.example.ventory.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager,
                          UserService userService,
                          JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    // 1️⃣ ميثود التسجيل (بتكلم الـ Business Service بتاعنا)
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LoginRequest request) {
        userService.registerUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok("User registered successfully!");
    }

    // 2️⃣ ميثود تسجيل الدخول (بتشغل الـ Security المدمج + توليد الـ JWT)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String token = jwtUtils.generateToken(authentication);
        return ResponseEntity.ok(token);
    }
}
