package com.example.secureloginsystem.controller;

import com.example.secureloginsystem.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password) {

        return authService.register(username, password);
    }

    @GetMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        return authService.login(username, password);
    }
}