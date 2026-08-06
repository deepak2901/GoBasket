package com.gobasket.gobasket.user.service;

import java.util.List;

import com.gobasket.gobasket.auth.dto.LoginRequest;
import com.gobasket.gobasket.auth.dto.LoginResponse;
import com.gobasket.gobasket.user.dto.UserRequest;
import com.gobasket.gobasket.user.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    LoginResponse login(LoginRequest request);
}