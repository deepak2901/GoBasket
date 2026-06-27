package com.gobasket.gobasket.service.impl;

import com.gobasket.gobasket.dto.UserRequest;
import com.gobasket.gobasket.dto.UserResponse;
import com.gobasket.gobasket.entity.User;
import com.gobasket.gobasket.repository.UserRepository;
import com.gobasket.gobasket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest request) {

        User user = User.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
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
}