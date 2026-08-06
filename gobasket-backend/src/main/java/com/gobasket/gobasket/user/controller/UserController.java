package com.gobasket.gobasket.user.controller;

import com.gobasket.gobasket.auth.dto.LoginRequest;
import com.gobasket.gobasket.auth.dto.LoginResponse;
import com.gobasket.gobasket.user.dto.UserRequest;
import com.gobasket.gobasket.user.dto.UserResponse;
import com.gobasket.gobasket.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/createuser")
    public UserResponse createUser(@Valid @RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/getallusers")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
    
}