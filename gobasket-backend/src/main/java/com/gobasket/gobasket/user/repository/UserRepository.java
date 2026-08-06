package com.gobasket.gobasket.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gobasket.gobasket.user.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByPhone(String phone);

    Optional<User> findByEmail(String email);

    Optional<User> findByPhoneAndPassword(String phone, String password);
}