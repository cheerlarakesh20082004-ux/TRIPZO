package com.tripzo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tripzo.dto.UserResponse;
import com.tripzo.entity.User;
import com.tripzo.repository.UserRepository;
import com.tripzo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
            .map(UserResponse::fromEntity)
            .toList();
    }

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
        return UserResponse.fromEntity(user);
    }

    @Override
    public UserResponse createUser(User user) {
        User saved = userRepository.save(user);
        return UserResponse.fromEntity(saved);
    }
}
