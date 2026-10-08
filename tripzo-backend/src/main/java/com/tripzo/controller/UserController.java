package com.tripzo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tripzo.dto.CreateUserRequest;
import com.tripzo.dto.UserResponse;
import com.tripzo.entity.User;
import com.tripzo.enums.UserRole;
import com.tripzo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody CreateUserRequest request) {
        User user = new User(
            request.fullName(),
            request.email(),
            request.phone(),
            request.password(),
            request.role() != null ? request.role() : UserRole.RIDER
        );
        return userService.createUser(user);
    }
}
