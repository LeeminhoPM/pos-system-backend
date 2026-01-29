package com.bluesky.pos_system.mappers;

import com.bluesky.pos_system.models.User;
import com.bluesky.pos_system.payload.dto.UserDTO;

public class UserMapper {
    public static UserDTO toDTO(User savedUser) {
        return UserDTO.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .fullName(savedUser.getFullName())
                .phone(savedUser.getPhone())
                .roles(savedUser.getRoles())
                .lastLogin(savedUser.getLastLogin())
                .createdAt(savedUser.getCreatedAt())
                .updatedAt(savedUser.getUpdatedAt())
                .build();
    }
}
