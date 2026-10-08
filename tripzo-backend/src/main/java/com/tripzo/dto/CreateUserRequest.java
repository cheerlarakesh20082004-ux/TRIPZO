package com.tripzo.dto;

import com.tripzo.enums.UserRole;

public record CreateUserRequest(
    String fullName,
    String email,
    String phone,
    String password,
    UserRole role
) {
}
