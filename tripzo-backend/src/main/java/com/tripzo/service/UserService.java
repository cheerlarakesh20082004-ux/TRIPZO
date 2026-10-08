package com.tripzo.service;

import java.util.List;

import com.tripzo.dto.UserResponse;
import com.tripzo.entity.User;

public interface UserService {
    List<UserResponse> findAll();
    UserResponse findById(Long id);
    UserResponse createUser(User user);
}
