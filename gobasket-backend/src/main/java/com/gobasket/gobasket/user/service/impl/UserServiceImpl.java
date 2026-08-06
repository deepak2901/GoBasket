package com.gobasket.gobasket.user.service.impl;

import com.gobasket.gobasket.auth.dto.LoginRequest;
import com.gobasket.gobasket.auth.dto.LoginResponse;
import com.gobasket.gobasket.auth.jwt.JwtService;
import com.gobasket.gobasket.exception.ResourceAlreadyExistsException;
import com.gobasket.gobasket.user.dto.UserRequest;
import com.gobasket.gobasket.user.dto.UserResponse;
import com.gobasket.gobasket.user.entity.User;
import com.gobasket.gobasket.user.repository.UserRepository;
import com.gobasket.gobasket.user.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public UserResponse createUser(UserRequest request) {

        userRepository.findByPhone(request.getPhone()).ifPresent(existingUser -> {
            throw new ResourceAlreadyExistsException("Phone number already exists");
        });

        userRepository.findByEmail(request.getEmail()).ifPresent(existingUser -> {
            throw new ResourceAlreadyExistsException("Email already exists");
        });

        User user = User.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("USER")
                .createdAt(LocalDateTime.now())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .phone(savedUser.getPhone())
                .email(savedUser.getEmail())
                .createdAt(savedUser.getCreatedAt())
                .build();
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(user -> UserResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .phone(user.getPhone())
            .email(user.getEmail())
            .createdAt(user.getCreatedAt())
            .build())
            .toList();

    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByPhone(request.getPhone())
                    .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());
        
        if (!matches) {
            throw new RuntimeException("Invalid credentials");
        }
        
        String token =jwtService.generateToken(user.getPhone());
        return LoginResponse.builder()
            .token(token)
            .build();
    }
}