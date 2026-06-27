package com.gobasket.gobasket.controller;

import com.gobasket.gobasket.dto.UserRequest;
import com.gobasket.gobasket.dto.UserResponse;
import com.gobasket.gobasket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }
}