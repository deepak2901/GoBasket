package com.gobasket.gobasket.service;

import com.gobasket.gobasket.dto.UserRequest;
import com.gobasket.gobasket.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest request);
}