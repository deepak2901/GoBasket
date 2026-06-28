package com.gobasket.gobasket.service;

import java.util.List;

import com.gobasket.gobasket.dto.LoginRequest;
import com.gobasket.gobasket.dto.LoginResponse;
import com.gobasket.gobasket.dto.UserRequest;
import com.gobasket.gobasket.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    LoginResponse login(LoginRequest request);
}